package com.cissst.bysales.service;

import java.util.List;

import com.cissst.bysales.daomain.Suppler;

/**
 * 供应商业务逻辑层
 * 
 * @author Administrator
 * 
 */
public interface Supplerservser {
	/**
	 * 添加
	 * 
	 * @param supper
	 * @return 行数
	 */
	public int addsupple(Suppler supper);

	/**
	 * 查询
	 * 
	 * @return List<Suppler>
	 */
	public List<Suppler> supplerfinally();

	/**
	 * 模糊查询
	 * 
	 * @param name
	 * @return List<Suppler>
	 */
	public List<Suppler> supplerfinallylike(String name);
}
