package com.cissst.bysales.dao.impl;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.cissst.bysales.dao.Productdao;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Suppler;
import com.cissst.bysales.utils.DbUtils;

/**
 * 商品数据访问实现层
 * @author Administrator
 *
 */
public class Productdaoimpl implements Productdao {
	// 添加
	@Override
	public int addProduct(Product product) {
		// TODO Auto-generated method stub
		if (product == null) {
			throw new RuntimeException("业务逻辑传过来的对象无效");
		}
		if (product.getSuppler() == null) {
			throw new RuntimeException("业务逻辑层传过来的供应商无效");
		}
		String sql = "insert into tb_product values(tb_prodect_sq.nextval,?,?,?,?,?,?,?,?)";
		int row = DbUtils.exequeupdate(sql, product.getProductno(), product
				.getProductname(), product.getProductauth(),
				product.getPrice(), product.getDiskno(), product.getSuppler()
						.getId(), product.getPubdate(), product.getMemo());
		DbUtils.fin();
		return row;
	}

	// 查询
	@Override
	public List<Product> fialyProduct() {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		Product pro = null;
		Suppler sup = null;
		String sql = "select * from tb_product";
		String sql2 = "select * from tb_suppler where id=?";
		ResultSet rs = DbUtils.exeque(sql);
		try {
			while (rs.next()) {
				pro = new Product(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getInt(6), rs.getDate(8), rs.getString(9));
				ResultSet rs2 = DbUtils.exeque(sql2, rs.getInt(7));
				if (rs2.next()) {
					sup = new Suppler(rs2.getInt(1), rs2.getString(2),
							rs2.getString(3), rs2.getString(4), rs2.getString(5),
							rs2.getString(6), rs2.getString(7), rs2.getString(8),
							rs2.getString(9), rs2.getString(10),
							rs2.getString(11), rs2.getString(12),
							rs2.getString(13));
				}
				pro.setSuppler(sup);
				list.add(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.fin();
		}
		return list;
	}

	// 模糊查询
	@Override
	public List<Product> finyproductlike(Map<String, Object> quency) {
		// TODO Auto-generated method stub
		if (quency == null) {
			throw new RuntimeException("业务逻辑数据有误");
		}
		List<Product> productlist = new ArrayList<Product>();
		if (quency.size() > 0) {
			// 键
			String quenAll = null;
			// 值
			String value = null;
			// 找到键值
			for (Map.Entry<String, Object> map : quency.entrySet()) {
				quenAll = map.getKey();
				value = (String) map.getValue();
			}
			Product pro = null;
			Suppler sup = null;
			String sql = "Select * from tb_product left join tb_suppler on tb_product.suppler=tb_suppler.id where "+quenAll+" like ?";
			String sql2 = "select * from tb_suppler where id=?";
			ResultSet rs = DbUtils.exeque(sql, "%" + value + "%");
			try {
				while (rs.next()) {
					pro = new Product(rs.getInt(1), rs.getString(2),
							rs.getString(3), rs.getString(4), rs.getDouble(5),
							rs.getInt(6), rs.getDate(8), rs.getString(9));
					ResultSet rs2 = DbUtils.exeque(sql2, rs.getInt(7));
					if (rs2.next()) {
						sup = new Suppler(rs2.getInt(1), rs2.getString(2),
								rs2.getString(3), rs2.getString(4),
								rs2.getString(5), rs2.getString(6),
								rs2.getString(7), rs2.getString(8),
								rs2.getString(9), rs2.getString(10),
								rs2.getString(11), rs2.getString(12),
								rs2.getString(13));
						pro.setSuppler(sup);
						productlist.add(pro);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DbUtils.fin();
			}
		}

		return productlist;
	}
//通过id 查询
	@Override
	public Product finallyid(Serializable id) {
		// TODO Auto-generated method stub
		if(id==null){
			throw new RuntimeException("无效参数");
		}
		Product pro = null;
		Suppler sup = null;
		String sql = "Select * from tb_product left join tb_suppler on tb_product.suppler=tb_suppler.id where tb_product.id=?";
		String sql2 = "select * from tb_suppler where id=?";
		ResultSet rs = DbUtils.exeque(sql,id);
		try {
			while (rs.next()) {
				pro = new Product(rs.getInt(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getDouble(5),
						rs.getInt(6), rs.getDate(8), rs.getString(9));
				ResultSet rs2 = DbUtils.exeque(sql2, rs.getInt(7));
				if (rs2.next()) {
					sup = new Suppler(rs2.getInt(1), rs2.getString(2),
							rs2.getString(3), rs2.getString(4),
							rs2.getString(5), rs2.getString(6),
							rs2.getString(7), rs2.getString(8),
							rs2.getString(9), rs2.getString(10),
							rs2.getString(11), rs2.getString(12),
							rs2.getString(13));
					pro.setSuppler(sup);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DbUtils.fin();
		
	}
		return pro;
}
}
