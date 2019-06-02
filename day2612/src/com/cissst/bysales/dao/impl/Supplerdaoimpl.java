package com.cissst.bysales.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.cissst.bysales.dao.Supplerdao;
import com.cissst.bysales.daomain.Suppler;
import com.cissst.bysales.utils.DbUtils;

/**
 * 供应商数据访问实现层
 * @author Administrator
 *
 */
public class Supplerdaoimpl implements Supplerdao {
//添加供应商
	@Override
	public int addsupple(Suppler supper) {
		// TODO Auto-generated method stub
		if(supper==null){
			throw new RuntimeException("该对象无效");
		}
		String sql="insert into tb_suppler values(tb_suppler_sq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		int row= DbUtils.exequeupdate(sql, supper.getSupplername(),supper.getSuppleraddr(),supper.getSupplertel(),
				supper.getSupplerper(),supper.getSupplerphone(),supper.getSupplerEmal(),supper.getSupplerQQ(),
				supper.getSupplerpost(),supper.getSupplerfax(),supper.getSupplerbank(),supper.getSuppleraccounton(),supper.getSupplermeno());
		DbUtils.fin();
		return row;
	}
//查询供应商
	@Override
	public List<Suppler> supplerfinally() {
		// TODO Auto-generated method stub
		String sql="select * from tb_suppler";
		ResultSet rs=DbUtils.exeque(sql);
		List<Suppler> list=new ArrayList<Suppler>();
		Suppler sup;
		try {
			while(rs.next()){
				sup=new Suppler(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13));
				list.add(sup);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		return list;
	}
//模糊查询供应商
	@Override
	public List<Suppler> supplerfinallylike(String name) {
		// TODO Auto-generated method stub
		String sql="select * from tb_suppler where supplername like ? ";
		ResultSet rs=DbUtils.exeque(sql, "%"+name+"%");
		List<Suppler> listlike=new ArrayList<Suppler>();
		Suppler supp;
		try {
			while(rs.next()){
				supp=new Suppler(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
						rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),
						rs.getString(12),rs.getString(13));
				listlike.add(supp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listlike;
	}

}
