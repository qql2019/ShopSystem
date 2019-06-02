package com.cissst.bysales.service.impl;

import java.util.List;

import com.cissst.bysales.dao.Supplerdao;
import com.cissst.bysales.dao.impl.Supplerdaoimpl;
import com.cissst.bysales.daomain.Suppler;
import com.cissst.bysales.service.Supplerservser;

/**
 * 供应商
 * @author Administrator
 *
 */
public class Supplerserverimpl implements Supplerservser {
	private Supplerdao sud=new Supplerdaoimpl();
	//添加供应商
	@Override
	public int addsupple(Suppler supper) {
		// TODO Auto-generated method stub
		return sud.addsupple(supper);
	}
//查询
	@Override
	public List<Suppler> supplerfinally() {
		// TODO Auto-generated method stub
		return sud.supplerfinally();
	}
//模糊查询
	@Override
	public List<Suppler> supplerfinallylike(String name) {
		// TODO Auto-generated method stub
		return sud.supplerfinallylike(name);
	}

}
