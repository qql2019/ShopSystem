package com.cissst.bysales.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.cissst.bysales.dao.Usersdao;
import com.cissst.bysales.daomain.Users;
import com.cissst.bysales.utils.DbUtils;

/**管理员登录
 * @author Administrator
 *
 */
public class Usersdaoimpl implements Usersdao {
//登录处理
	@Override
	public Users islogin(String username, String userpass) {
		String sql="select * from tb_users where username=? and userpass=?";
		Users user=null;
		ResultSet rs=DbUtils.exeque(sql, username,userpass);
		try {
			if(rs.next()){
				user=new Users(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

}
