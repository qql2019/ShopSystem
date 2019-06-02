package com.cissst.bysales.service.impl;

import java.util.List;
import java.util.Map;

import com.cissst.bysales.dao.Inpaydao;
import com.cissst.bysales.dao.impl.Inpaydaoimpl;
import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Inpay;
import com.cissst.bysales.service.Inpayserver;

/**
 * 入库结账
 * @author Administrator
 *
 */
public class Inpayserviceimpl implements Inpayserver {
private Inpaydao indao=new Inpaydaoimpl();
//查询
	@Override
	public List<In> finallywithBlank() {
		// TODO Auto-generated method stub
		return indao.finallywithBlank();
	}
//根据id查询
	@Override
	public In finallyInid(String id) {
		// TODO Auto-generated method stub
		return indao.finallyInid(id);
	}
//添加
	@Override
	public int addInpay(Inpay inpay) {
		// TODO Auto-generated method stub
		return indao.addInpay(inpay);
	}

	@Override
	public String finallMaxid() {
		// TODO Auto-generated method stub
		return indao.finallMaxid();
	}
	@Override
	public List<Inpay> finallyinpay() {
		// TODO Auto-generated method stub
		return indao.finallyinpay();
	}
	@Override
	public List<Inpay> finallyinpaylike(Map<String, Object> produ) {
		// TODO Auto-generated method stub
		return indao.finallyinpaylike(produ);
	}

}
