package com.cissst.bysales.dao;

import java.util.List;
import java.util.Map;

import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Save;

/**
 * 库存数据访问层
 * 
 * @author Administrator
 * 
 */
/**
 * @author Administrator
 *
 */
/**
 * @author Administrator
 *
 */
public interface Insavedao {
	/**
	 * 获取最大主键
	 * 
	 * @return
	 */
	public String finalMaxpk();

	/**
	 * 商品加入仓库
	 * 
	 * @param in
	 * @return 行数是否成功
	 */
	public int addin(In in);
	/**查询所有入库商品
	 * @return
	 */
	public List<In> finallyIn();
	/**
	 * 模糊查询
	 * @return
	 */
	public List<In> finallyInlike(Map<String, Object> map);
	/**
	 * 查询所有
	 * @return
	 */
	public List<In> finallyInBlank();
}
