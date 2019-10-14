package com.universe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.universe.service.ResourceService;
import com.universe.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthTest {

  @Autowired
  private UserService userService;

  @Autowired
  private ResourceService resourceService;

  @Test
  public void userMapperTest() {
    System.err.println(resourceService.getPermissionsByUsername("root"));
  }

}