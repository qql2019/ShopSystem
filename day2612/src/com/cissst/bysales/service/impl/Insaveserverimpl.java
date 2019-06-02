package com.cissst.bysales.service.impl;

import java.util.List;
import java.util.Map;

import com.cissst.bysales.dao.Insavedao;
import com.cissst.bysales.dao.impl.Insavedaoimpl;
import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.service.Insaveserver;

/**
 * 入库
 * @author Administrator
 *
 */
public class Insaveserverimpl implements Insaveserver {
private Insavedao ido=new Insavedaoimpl();
//获取最大主键
@Override
public String finalMaxpk() {
	// TODO Auto-generated method stub
	return ido.finalMaxpk();
}
//添加
	@Override
	public int addin(In in) {
		// TODO Auto-generated method stub
		return ido.addin(in);
	}
	@Override
	public List<In> finallyIn() {
		// TODO Auto-generated method stub
		return ido.finallyIn();
	}
	@Override
	public List<In> finallyInlike(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return ido.finallyInlike(map);
	}
	@Override
	public List<In> finallyInBlank() {
		// TODO Auto-generated method stub
		return ido.finallyIn();
	}
}
