package com.cissst.bysales.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.cissst.bysales.dao.Productdao;
import com.cissst.bysales.dao.impl.Productdaoimpl;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.service.Productserver;

/**商品
 * @author Administrator
 *
 */
public class Productserverimpl implements Productserver {
		private Productdao prd=new Productdaoimpl();
		//添加
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		return prd.addProduct(product);
	}
//查询
	@Override
	public List<Product> fialyProduct() {
		// TODO Auto-generated method stub
		return prd.fialyProduct();
	}
//模糊查询
	@Override
	public List<Product> finyproductlike(Map<String, Object> quency) {
		// TODO Auto-generated method stub
		return prd.finyproductlike(quency);
	}
//通过id查询
	@Override
	public Product finallyid(Serializable id) {
		// TODO Auto-generated method stub
		return prd.finallyid(id);
	}

}
