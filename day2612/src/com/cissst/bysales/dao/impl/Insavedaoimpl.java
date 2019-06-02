package com.cissst.bysales.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cissst.bysales.dao.Insavedao;
import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Save;
import com.cissst.bysales.daomain.Suppler;
import com.cissst.bysales.utils.DbUtils;

/**
 * 
 * 入库数据访问实现层
 * @author Administrator
 *
 */
public class Insavedaoimpl implements Insavedao {
	//获取最大主键
	@Override
	public String finalMaxpk() {
	String sql="select max(id) from tb_in";
	ResultSet rs=DbUtils.exeque(sql);
	String maxid=null;

	try {
		if(rs.next()){
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
	public int addin(In in) {
		Connection conn=DbUtils.getcon();
		String sql1="insert into tb_in(id,product,inprice" +
				",innum,inmeny,indate,persnon,inallperson,balance,closeaccount,memo) values(?,?,?,?,?,?,?,?,?,?,?)";
		String sql2="insert into tb_save(id,product,productnum,productprice,productmoney) values(tb_save_seq.nextval,?,?,?,?)";
		String sql3="update tb_save set productnum=productnum+?,productprice=?,productmoney=productmoney+?  where product=?";
		String sql4="select * from tb_save where product=?";
		ResultSet rs=DbUtils.exeque(sql4,in.getProduct().getId());
		//用于判断仓库是否存在该商品
		boolean flag=false;
		//添加或改变存在商品的行数
		int row = 0;
		try {
			if(rs.next()){
				//仓库存在该商品
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		PreparedStatement ps3=null;
		try {
			//开启事物
			conn.setAutoCommit(false);
			//获取执行语句对象
			 ps1=conn.prepareStatement(sql1);
			 ps2=conn.prepareStatement(sql2);
			 ps3=conn.prepareStatement(sql3);
			//给占位参数赋值
			DbUtils.setpreparement(ps1, in.getId(),in.getProduct().getId(),in.getInprice(),in.getInnum(),
					in.getInmeny(),in.getIndate(),in.getPersnon(),in.getInallperson(),
					in.getBalance(),in.getCloseaccount(),in.getMemo());
			DbUtils.setpreparement(ps2,in.getProduct().getId(),in.getInnum(),in.getInprice(),in.getInmeny());
			DbUtils.setpreparement(ps3,in.getInnum(),in.getInprice(),in.getInmeny(),in.getProduct().getId());
			//预处理
			ps1.executeUpdate();
			if(flag){//如果商品存在修改库存
				ps3.executeUpdate();
			}else{//如果商品不存在添加库存
				ps2.executeUpdate();
			}
			//成功提交事物
			conn.commit();
			row=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				//失败回滚事物
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				DbUtils.closeResult(ps1, conn);
				DbUtils.closeResult(ps2, conn);
				DbUtils.closeResult(ps3, conn);
			}
		}
		return row;
	
	}
	//查询所有入库商品
	
	@Override
	public List<In> finallyIn() {
		List<In> list=new ArrayList<In>();
		In in;
		Product pro = null;
		String sql="select * from tb_in ";
		String sql2 = "select productname from tb_product where id=?";
		
		ResultSet rs = DbUtils.exeque(sql);
		try {
			while(rs.next()){
				in=new In(rs.getString(1), rs.getDouble(3),rs.getInt(4), rs.getDouble(5),
						rs.getDate(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getString(10), rs.getString(11));
					ResultSet rs1 = DbUtils.exeque(sql2, rs.getInt(2));
					if(rs1.next()){
						pro=new Product(rs1.getString("productname"));
					}
					in.setProduct(pro);
				
				list.add(in);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		return list;
	}
	@Override
	public List<In> finallyInlike(Map<String, Object> map) {
		if(map==null){
			throw new RuntimeException("无效字符");
		}
		List<In> list =new ArrayList<In>();
		In in;
		Product pro = null;
		if(map.size()>0){
			String mapkeyk=null;
			String value=null;
			for (Map.Entry<String, Object> ma : map.entrySet()) {
				 mapkeyk = ma.getKey();
				 value=(String)ma.getValue();
			}
			String sql="select * from tb_in left join tb_product on tb_in.product =tb_product.id where "+mapkeyk+" like ? "; 
			String sql2="select productname from tb_product where id=?";
			ResultSet rs = DbUtils.exeque(sql,"%"+value+"%");
			try {
				while(rs.next()){
					in=new In(rs.getString(1), rs.getDouble(3),rs.getInt(4), rs.getDouble(5),
							rs.getDate(6), rs.getString(7), rs.getString(8), rs.getDouble(9), rs.getString(10), rs.getString(11));
						ResultSet rs1 = DbUtils.exeque(sql2, rs.getInt(2));
						if(rs1.next()){
							pro=new Product(rs1.getString("productname"));
						}
						in.setProduct(pro);
					
					list.add(in);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.fin();
			}
		}
		return list;
		
		
	}
	public List<In> finallyInBlank() {
		String sql=" select * from tb_in left join tb_product " +
				"on tb_in.product=tb_product.id  left join tb_suppler on tb_product.suppler=tb_suppler.id where  closeaccount=?";
			ResultSet rs=DbUtils.exeque(sql);
			List<In> list=new ArrayList<In>();
			In in=null;
			Product pro=null;
			Suppler sup=null;
			try {
				while(rs.next()){
					//ID   PRODUCT    INPRICE      INNUM     INMENY INDATE      PERSNON    INALLPERSON      BALANCE CLOSEACCOUNT    MEMO                                                                                     
				///	ID PRODUCTNO  PRODUCTNAME     PRODUCTAUTH       PRICE     DISKNO    SUPPLER PUBDATE     MEMO                                                                                    
					 //ID SUPPLERNAME       SUPPLERADDR     SUPPLERTEL       SUPPLERPER   SUPPLERPHONE     SUPPLEREMAL       SUPPLERQQ  SUPPLERPOST  SUPPLERFAX     SUPPLERBANK     SUPPLERACCOUNTON    SUPPLERMENO
					in=new In(rs.getString(1),rs.getDouble(3),rs.getInt(4),
							rs.getDouble(5),rs.getDate(6),
							rs.getString(7),rs.getString(8)
							,rs.getDouble(9)
							,rs.getString(10),rs.getString(11));
					pro=new Product(rs.getInt(12),rs.getString(13),rs.getString(14),
							rs.getString(15),rs.getDouble(16),rs.getInt(17)
							,rs.getDate(19),rs.getString(20));
					sup=new Suppler(rs.getInt(21),rs.getString(22),rs.getString(23),rs.getString(24),rs.getString(25)
							,rs.getString(26),rs.getString(27),rs.getString(28),rs.getString(29),rs.getString(30),rs.getString(31)
							,rs.getString(32),rs.getString(33));
					pro.setSuppler(sup);
					in.setProduct(pro);
					list.add(in);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.fin();
			}
			return list;
		}
}

