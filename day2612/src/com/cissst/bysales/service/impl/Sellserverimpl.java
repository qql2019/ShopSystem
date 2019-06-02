package com.cissst.bysales.service.impl;

import java.util.List;

import com.cissst.bysales.dao.Selldao;
import com.cissst.bysales.dao.impl.Selldaoimpl;
import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.daomain.Sell;
import com.cissst.bysales.service.Sellserver;

/**
 * 销售业务逻辑实现层
 * @author Administrator
 *
 */
public class Sellserverimpl implements Sellserver {
private Selldao  selldao=new Selldaoimpl();
//查询最大主键
	@Override
	public String finMaxId() {
		// TODO Auto-generated method stub
		return selldao.finMaxId();
	}
//添加
	@Override
	public int addsell(Sell sell) {
		// TODO Auto-generated method stub
		return selldao.addsell(sell);
	}
	@Override
	public List<Save> finallsaveproduct() {
		// TODO Auto-generated method stub
		return selldao.finallsaveproduct();
	}
	@Override
	public Save finallsaveproductByPK(int id) {
		// TODO Auto-generated method stub
		return selldao.finallsaveproductByPK(id);
	}

}
