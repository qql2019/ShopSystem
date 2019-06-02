package com.cissst.bysales.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cissst.bysales.dao.Selldao;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.daomain.Sell;
import com.cissst.bysales.utils.DbUtils;

/**
 * 销售数据访问实现层
 * @author Administrator
 *
 */
public class Selldaoimpl implements Selldao {
//获取主键
	@Override
	public String finMaxId() {
		String sql="select max(id) from tb_sell ";
		String maxid=null;
		ResultSet rs = DbUtils.exeque(sql);
try {
	while(rs.next()){
		maxid=rs.getString(1);
	}
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally{
	DbUtils.fin();
}
		return maxid;
	}
	//添加
	@Override
	public int addsell(Sell sell) {
		if(sell==null||sell.getProduct()==null||sell.getCustomer()==null){
			throw new RuntimeException("业务逻辑数据无效");
		}
		String sql1="insert into tb_sell values(?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql2="update tb_save set productnum=productnum-?,productmoney=productnum*productPrice where product=? ";
		Connection conn = DbUtils.getcon();
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		int roecon=0;
		try {
			ps1=conn.prepareStatement(sql1);
			 ps2 = conn.prepareStatement(sql2);
			 DbUtils.setpreparement(ps1,sell.getId(),sell.getProduct().getId(),sell.getProductPrice(),
					 sell.getProductnum(),sell.getProductmoney(),sell.getCustomer().getId(),
					 sell.getSelldate(),sell.getOperator(),
					 sell.getAllwebperson(),sell.getMemo(),sell.getSellbalan(),sell.getCloseaccount());
			 DbUtils.setpreparement(ps2,sell.getProductnum(),sell.getProduct().getId());
			 ps1.executeUpdate();
			 ps2.executeUpdate();
			 //提交事物
			 conn.commit();
			 roecon=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				//失败回滚
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
		
		return roecon;
	}
	//查询库存商品
	@Override
	public List<Save> finallsaveproduct() {
		List<Save> list=new ArrayList<Save>();
		Save save;
		Product pro=null;
		String sql="select *  from tb_save left join tb_product on tb_save.product=tb_product.id";
		ResultSet rs = DbUtils.exeque(sql);
		 //ID    PRODUCT PRODUCTNUM PRODUCTPRICE PRODUCTMONEY MEMO 
		//ID PRODUCTNO PRODUCTNAME      PRODUCTAUTH   
		//PRICE     DISKNO    SUPPLER PUBDATE     MEMO
		try {
			while(rs.next()){
				save=new Save(rs.getInt(1),rs.getInt(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6));
				pro=new Product(rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDouble(11),
						rs.getInt(12),rs.getDate(14),rs.getString(15));
			save.setProduct(pro);
			list.add(save);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		return list;
	}
	//根据id查询
	@Override
	public Save finallsaveproductByPK(int id) {
		Save save = null;
		Product pro=null;
		String sql="select *  from tb_save left join tb_product on tb_save.product=tb_product.id where tb_product.id=?";
		ResultSet rs = DbUtils.exeque(sql, id);
		try {
			while(rs.next()){
				save=new Save(rs.getInt(1),rs.getInt(3),rs.getDouble(4),rs.getDouble(5),rs.getString(6));
				pro=new Product(rs.getInt(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDouble(11),
						rs.getInt(12),rs.getDate(14),rs.getString(15));
			save.setProduct(pro);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		
		return save;
	}

}
