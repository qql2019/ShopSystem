package com.cissst.bysales.service.impl;

import com.cissst.bysales.dao.Rkthdao;
import com.cissst.bysales.dao.impl.Rkthdaoimpl;
import com.cissst.bysales.daomain.Rkth;
import com.cissst.bysales.service.Rkthserver;

public class Rkthserverimpl implements Rkthserver {
private Rkthdao rdt=new Rkthdaoimpl();
	@Override
	public String maxId() {
		// TODO Auto-generated method stub
		return rdt.maxId();
	}

	@Override
	public int addRuth(Rkth rkth) {
		// TODO Auto-generated method stub
		return rdt.addRuth(rkth);
	}

	@Override
	public int finallsumById(String inid) {
		// TODO Auto-generated method stub
		return rdt.finallsumById(inid);
	}

}
