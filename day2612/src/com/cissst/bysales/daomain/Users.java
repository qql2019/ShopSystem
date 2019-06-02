package com.cissst.bysales.daomain;

import java.io.Serializable;

//管理员实体类
public class Users implements Serializable {
private int id;//标志属性
private String username;//用户名
private String userpass;//密码
private String realname;//真实姓名
public Users() {
	super();
	// TODO Auto-generated constructor stub
}
public Users(int id, String username, String userpass, String realname) {
	super();
	this.id = id;
	this.username = username;
	this.userpass = userpass;
	this.realname = realname;
}
public Users(String username, String userpass, String realname) {
	super();
	this.username = username;
	this.userpass = userpass;
	this.realname = realname;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpass() {
	return userpass;
}
public void setUserpass(String userpass) {
	this.userpass = userpass;
}
public String getRealname() {
	return realname;
}
public void setRealname(String realname) {
	this.realname = realname;
}

}
