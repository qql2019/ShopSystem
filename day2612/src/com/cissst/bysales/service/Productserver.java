package com.cissst.bysales.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cissst.bysales.daomain.Product;

/**
 * 商品业务逻辑层
 * @author Administrator
 *
 */
public interface Productserver {
	
	/**
	 * 添加商品
	 * @param product
	 * @return 影响行数
	 */
	public int addProduct(Product product);

	/**
	 * 查询所有商品
	 * @return
	 */
	public List<Product> fialyProduct();
	/**
	 * 根据条件模糊查询
	 * @param quency
	 * @return map集合键对应的值
	 */
	public List<Product> finyproductlike(Map<String,Object> quency);
	/**
	 * 根据id 查询
	 * @param id
	 * @return 商品
	 */
	public Product finallyid(Serializable id);
}
