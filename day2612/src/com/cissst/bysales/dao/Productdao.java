package com.cissst.bysales.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cissst.bysales.daomain.Product;


/**
 * 商品数据访问层
 * @author Administrator
 *
 */
public interface Productdao {
	
/**
 * 添加商品
 * @param product
 * @return 返回自然数成功反之失败
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
 * @return
 */
public List<Product> finyproductlike(Map<String,Object> quency);

/**
 * 通过id 查询订单
 * @param id
 * @return
 */
public Product finallyid(Serializable id);
}
