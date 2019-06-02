package com.cissst.bysales.service;

import java.util.List;
import java.util.Map;

import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Inpay;

/**
 * 入库结账业务逻辑层
 * @author Administrator
 *
 */
public interface Inpayserver {
	
		/**
		 * 获取没有结清的入库信息
		 * @return
		 */
		public List<In> finallywithBlank();
		/**
		 * 根据id 获取实体
		 * @param id
		 * @return 实体
		 */
		public In finallyInid(String id);
		/**
		 * 入库结账
		 * @param inpay
		 * @return
		 */
		public int addInpay(Inpay inpay);
		/**
		 * 获取商品最大id
		 * @return id
		 */
		public String finallMaxid();
		
		public List<Inpay> finallyinpay();

		/**
		 * 模糊查询
		 * @param produ
		 * @return
		 */
		public List<Inpay> finallyinpaylike(Map<String ,Object> produ);
}
