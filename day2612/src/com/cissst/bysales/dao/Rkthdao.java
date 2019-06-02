package com.cissst.bysales.dao;

import com.cissst.bysales.daomain.Rkth;

/**
 * 入库退货
 * @author Administrator
 *
 */
public interface Rkthdao {
/**
 * 获取最大ID
 * @return
 */
public String maxId();
/**
 * 记录添加
 * @param rkth
 * @return
 */
public int addRuth(Rkth rkth);
/**
 * 根据入库id获取该类商品总数量
 * @param inid
 * @return
 */
public int finallsumById(String inid);
}
