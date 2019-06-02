package com.cissst.bysales.dao;

import com.cissst.bysales.daomain.Users;

/**
 * 用户登录数据访问层
 * @author Administrator
 *
 */
public interface Usersdao {

/**
 * 处理登录
 * @param usaername 用户名
 * @param userpass 密码
 * @return 用户
 */
public Users islogin(String username,String userpass);
}
