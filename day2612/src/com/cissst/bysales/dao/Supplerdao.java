package com.cissst.bysales.dao;

import java.util.List;

import com.cissst.bysales.daomain.Suppler;

/**
 * 供应商数据访问层
 * @author Administrator
 *
 */
public interface Supplerdao {
	/**
	 * 添加供应商
	 * @param supper
	 * @return 行数
	 */
	public int  addsupple(Suppler supper);
	/**
	 * 查询
	 * @return
	 */
	public  List<Suppler> supplerfinally();
	/**
	 * 模糊查询
	 * @param name
	 * @return
	 */
	public List<Suppler> supplerfinallylike(String name);
}
