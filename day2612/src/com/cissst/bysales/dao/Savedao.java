package com.cissst.bysales.dao;

import java.util.List;

import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Save;

/**
 * 库存查询
 * @author Administrator
 *
 */
public interface Savedao {
	/**
	 * 查询
	 * @return 集合
	 */
	public List<Save>  finalsave();
	/**
	 * 模糊查询
	 * @param product 商品名
	 * @return 集合
	 */
	public List<Save>  finalsavelike(String  parameter);
}
