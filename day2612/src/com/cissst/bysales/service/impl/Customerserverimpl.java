package com.cissst.bysales.service.impl;

import java.util.List;

import com.cissst.bysales.dao.Customerdao;
import com.cissst.bysales.dao.impl.Customerdaoimpl;
import com.cissst.bysales.daomain.Customer;
import com.cissst.bysales.service.Customerserver;

/**
 * 客户业务逻辑实现层
 * @author Administrator
 *
 */
public class Customerserverimpl implements Customerserver {
	private Customerdao cud=new Customerdaoimpl();
	//添加
	@Override
	public int addcust(Customer customer) {
		// TODO Auto-generated method stub
		return cud.addcust(customer);
	}
//查询
	@Override
	public List<Customer> finallcust() {
		// TODO Auto-generated method stub
		return cud.finallcust();
	}
//模糊查询
	@Override
	public List<Customer> finacustlike(String name) {
		// TODO Auto-generated method stub
		return cud.finacustlike(name);
	}

}
