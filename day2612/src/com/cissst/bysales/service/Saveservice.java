package com.cissst.bysales.service;

import java.util.List;

import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Save;


/**
 * 库存查询
 * @author Administrator
 *
 */
public interface Saveservice {
/**
 * 查询
 * @return 集合
 */
public List<Save>  finalsave();
/**
 * 模糊查询
 * @param parameter 商品名
 * @return 集合
 */
public List<Save>  finalsavelike(String  parameter);
/**
 * 根据库存查询商品
 * @return
 */

}
