
package com.cissst.bysales.dao;

import java.util.List;

import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.daomain.Sell;

/**
 * 销售数据访问层
 * @author Administrator
 *
 */
public interface Selldao {
	/**
	 * 获取最大主键
	 * @return 最大主键
	 */
	public String finMaxId();
	/**
	 * 增加销售记录
	 * @param sell
	 * @return 行数
	 */
	public  int addsell(Sell sell);
	/**
	 * 根据库存查询商品
	 * @return
	 */
	public List<Save> finallsaveproduct(); 
/**
 * 根据id获取商品
 * @return 库存商品
 */
public Save finallsaveproductByPK(int id);	
}
