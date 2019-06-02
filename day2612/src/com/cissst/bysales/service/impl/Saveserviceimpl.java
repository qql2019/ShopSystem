package com.cissst.bysales.service.impl;

import java.util.List;

import com.cissst.bysales.dao.Savedao;
import com.cissst.bysales.dao.impl.Savedaoimpl;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.service.Saveservice;

public class Saveserviceimpl implements Saveservice {
private Savedao savd=new Savedaoimpl();
	@Override
	public List<Save> finalsave() {
		// TODO Auto-generated method stub
		return savd.finalsave();
	}

	@Override
	public List<Save> finalsavelike(String  parameter) {
		// TODO Auto-generated method stub
		return savd.finalsavelike(parameter);
	}

}
