package com.cissst.bysales.service;

import com.cissst.bysales.daomain.Users;

public interface Usersservice {
	/**
	 * 处理登录
	 * @param usaername 用户名
	 * @param userpass 密码
	 * @return 用户
	 */
	public Users islogin(String username,String userpass);
}
