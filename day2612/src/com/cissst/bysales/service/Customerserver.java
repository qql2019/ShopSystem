package com.cissst.bysales.service;

import java.util.List;

import com.cissst.bysales.daomain.Customer;


/**
 * 客户业务逻辑层
 * @author Administrator
 *
 */
public interface Customerserver {
/**
 * 添加
 * @param customer
 * @return 用户
 */
public int  addcust(Customer customer);
/**查询用户
 * @return 集合
 */
public List<Customer> finallcust();
/**
 * 根据姓名模糊查询
 * @return 集合
 */
public List<Customer> finacustlike(String name);
}
