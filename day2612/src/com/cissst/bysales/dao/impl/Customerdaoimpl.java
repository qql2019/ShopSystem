package com.cissst.bysales.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cissst.bysales.dao.Customerdao;
import com.cissst.bysales.daomain.Customer;
import com.cissst.bysales.utils.DbUtils;

/**
 * 客户数据访问实现层
 * @author Administrator
 *
 */
public class Customerdaoimpl implements Customerdao {
	//添加
	@Override
	public int addcust(Customer customer) {
		
		if(customer==null){
			throw new RuntimeException("该对象无效");
		}
		//tb_customer_sq为序列
		String sql="insert into tb_customer values(tb_customer_sq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		int row=DbUtils.exequeupdate(sql,customer.getCustname(),customer.getCustattr(),customer.getCusttel(),customer.getCustpersion(),customer.getCustpertel(),
				customer.getCustfax(),customer.getCustemail(),customer.getCustQQ(),customer.getCustbank(),
				customer.getCustaccountno(),customer.getCustmeno(),customer.getCustpostcod());
			DbUtils.fin();
		return row;
	}
//查询
	@Override
	public List<Customer> finallcust() {
		// TODO Auto-generated method stub
		String sql="select * from tb_customer";
		ResultSet rs=DbUtils.exeque(sql);
		List<Customer> list=new ArrayList<Customer>();
		Customer cust;
		try {
			while(rs.next()){
				cust=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13));
				list.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		return list;
	}
//模糊查询
	@Override
	public List<Customer> finacustlike(String name) {
		// TODO Auto-generated method stub
		String sql="select * from tb_customer where custname like ?";
		ResultSet rs=DbUtils.exeque(sql,"%"+name+"%");
		List<Customer> listc=new ArrayList<Customer>();
		Customer cust;
		try {
			while(rs.next()){
				cust=new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13));
				listc.add(cust);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listc;
	}

}
