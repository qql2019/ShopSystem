package com.cissst.bysales.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cissst.bysales.dao.Savedao;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.utils.DbUtils;

public class Savedaoimpl implements Savedao {

	@Override
	public List<Save> finalsave() {
		List<Save> lista=new ArrayList<Save>();
		Save sa;
		Product pro=null;
		String sql1="select * from tb_save";
		String sql2="select productname from tb_product where id=? ";
		ResultSet rs = DbUtils.exeque(sql1);
		try {
			while(rs.next()){
				sa=new Save(rs.getInt(1),rs.getInt(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6));
				ResultSet rs1 = DbUtils.exeque(sql2, rs.getInt(2));
				while(rs1.next()){
					pro=new Product(rs1.getString("productname"));
				}
				sa.setProduct(pro);
				lista.add(sa);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		return lista;
	}

	@Override
	public List<Save> finalsavelike(String  parameter) {
		List<Save> listsa=new ArrayList<Save>();
		Save sa;
		Product pro=null;
		String sql1="select * from tb_save left join tb_product on tb_save.product= tb_product.id  " +
				"where tb_product.productname like ?";
			String sql2="select productname from tb_product  where productname like ? ";
				ResultSet rs = DbUtils.exeque(sql1, "%"+parameter+"%");
				try {
					while(rs.next()){
						sa=new Save(rs.getInt(1),rs.getInt(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6));
						ResultSet rs1 = DbUtils.exeque(sql2,"%"+parameter+"%");
						while(rs1.next()){
							pro=new Product(rs1.getString("productname"));
						}
						sa.setProduct(pro);
						listsa.add(sa);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DbUtils.fin();
				}
		return listsa;
	}

}
