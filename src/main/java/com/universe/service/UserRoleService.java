/*
 * Copyright (C) 2011-2019 ShenZhen iBOXCHAIN Information Technology Co.,Ltd.
 *
 * All right reserved.
 *
 * This software is the confidential and proprietary
 * information of iBoxChain Company of China.
 * ("Confidential Information"). You shall not disclose
 * such Confidential Information and shall use it only
 * in accordance with the terms of the contract agreement
 * you entered into with iBoxchain inc.
 */
package com.universe.service;

import com.universe.common.entity.po.UserRole;

/**
 * @author: liuyalou
 * @date: 2019年8月16日
 */
public interface UserRoleService {

  Integer playRole(UserRole userRole);

  Integer deleteUserRoleById(Integer id);
}
