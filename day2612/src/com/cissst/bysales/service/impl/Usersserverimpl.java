package com.cissst.bysales.service.impl;

import com.cissst.bysales.dao.Usersdao;
import com.cissst.bysales.dao.impl.Usersdaoimpl;
import com.cissst.bysales.daomain.Users;
import com.cissst.bysales.service.Usersservice;

/**登录处理
 * 
 * @author Administrator
 *
 */
public class Usersserverimpl implements Usersservice {
    private Usersdao userdao=new Usersdaoimpl();
	@Override
	public Users islogin(String username, String userpass) {
		// TODO Auto-generated method stub
		return userdao.islogin(username, userpass);
	}

}
