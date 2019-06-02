package com.cissst.bysales.dao;

import java.util.List;

import com.cissst.bysales.daomain.Customer;

/**
 * 客户数据访问层
 * @author Administrator
 *
 */
public interface Customerdao {
		/**
		 * 添加
		 * @param customer
		 * @return 用户
		 */
		public int  addcust(Customer customer);
		/**查询用户
		 * @return
		 */
		public List<Customer> finallcust();
		/**
		 * 根据姓名模糊查询
		 * @return
		 */
		public List<Customer> finacustlike(String name);
		
}
