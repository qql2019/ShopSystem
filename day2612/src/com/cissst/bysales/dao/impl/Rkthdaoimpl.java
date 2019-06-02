package com.cissst.bysales.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cissst.bysales.dao.Rkthdao;
import com.cissst.bysales.daomain.Rkth;
import com.cissst.bysales.utils.DbUtils;

public class Rkthdaoimpl implements Rkthdao {
//获取最大id
	@Override
	public String maxId() {
		String sql="select max(id) from tb_rkth";
		ResultSet rs = DbUtils.exeque(sql);
		try {
			if(rs.next()){
				return rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		return null;
	}

	@Override
	public int addRuth(Rkth rkth) {
		String sql1="insert into tb_rkth values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2="update tb_save set productnum=productnum-?,productmoney=productmoney-? where product=?";
		Connection conn = DbUtils.getcon();
		int row=0;
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		try {

			conn.setAutoCommit(false);
			 ps1=conn.prepareStatement(sql1);
			 ps2=conn.prepareStatement(sql2);
			DbUtils.setpreparement(ps1,rkth.getId(),rkth.getIn().getId(),rkth.getProductname(),
					rkth.getSupplername(),rkth.getProductprice(),rkth.getProductmoney(),
					rkth.getRkthdate(),rkth.getOperator(),rkth.getAllowebperson(),
					rkth.getUnpaymoney(),rkth.getCloseaccount(),rkth.getProductnum(),rkth.getMemo());
				DbUtils.setpreparement(ps2, rkth.getProductnum(),rkth.getProductmoney(),rkth.getIn().getProduct().getId());
				ps1.executeUpdate();
				ps2.executeUpdate();
			conn.commit();
			row=1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DbUtils.closeResult(ps1, conn);
			DbUtils.closeResult(ps2, conn);
			
		}
		
		return row;
	}

	@Override
	public int finallsumById(String inid) {
		String sql="select sum(productnum) from tb_rkth where in_id=?";
		ResultSet rs = DbUtils.exeque(sql, inid);
		try {
			if(rs.next()){
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
