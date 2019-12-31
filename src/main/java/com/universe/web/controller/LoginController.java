package com.universe.web.controller;

import com.alibaba.druid.util.StringUtils;
import com.universe.common.util.ShiroUtils;
import com.universe.pojo.dto.request.LoginRequestDto;
import com.universe.pojo.dto.response.GenericResponseDto;
import com.wf.captcha.ArithmeticCaptcha;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.pam.UnsupportedTokenException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

	private static final String CAPTCHA_KEY = "captcha";

	@PostMapping(value = "/auth/login", produces = MediaType.APPLICATION_JSON_VALUE)
	public GenericResponseDto<?> login(LoginRequestDto requestDto) {
		String username = requestDto.getUsername();
		String password = requestDto.getPassword();
		boolean rememberMe = requestDto.isRemembered();
		String captcha = requestDto.getCaptcha();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);

		Subject subject = ShiroUtils.getSubject();
		String realCaptcha = ShiroUtils.getSessionAttribute(CAPTCHA_KEY, String.class);
		if (!StringUtils.equalsIgnoreCase(captcha, realCaptcha)) {
			throw new UnsupportedTokenException("验证码错误!");
		}

		subject.login(token);
		// 登录成功后去除验证码
		ShiroUtils.removeSessionAttribute(CAPTCHA_KEY);
		return GenericResponseDto.builder().resultCode(1).build();
	}

	@GetMapping(value = "/auth/captcha", produces = MediaType.APPLICATION_JSON_VALUE)
	public GenericResponseDto<String> generateVerifyCode() {
		ArithmeticCaptcha captcha = new ArithmeticCaptcha(130, 50,2);
		Session session = ShiroUtils.getSession();
		ShiroUtils.setSessionAttribute(CAPTCHA_KEY, captcha.text());

		return GenericResponseDto.<String>builder()
			.resultCode(1)
			.content(captcha.toBase64())
			.build();
	}

}
