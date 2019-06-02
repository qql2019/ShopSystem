package com.cissst.bysales.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.cissst.bysales.dao.Inpaydao;
import com.cissst.bysales.daomain.In;
import com.cissst.bysales.daomain.Inpay;
import com.cissst.bysales.daomain.Product;
import com.cissst.bysales.daomain.Suppler;
import com.cissst.bysales.utils.DbUtils;

/**入库结账数据访问实现层
 * @author Administrator
 *
 */
public class Inpaydaoimpl implements Inpaydao {

	//查询所有商品
	@Override
	public List<In> finallywithBlank() {
	String sql=" select * from tb_in left join tb_product " +
			"on tb_in.product=tb_product.id  left join tb_suppler on tb_product.suppler=tb_suppler.id where  closeaccount=?";
		ResultSet rs=DbUtils.exeque(sql, "否");
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
//根据id查找到对应商品
	@Override
	public In finallyInid(String id) {
		if(id==null){
			throw new RuntimeException("id为空");
		}
		String sql="select * from tb_in left join tb_product on tb_in.product=tb_product.id	 left join tb_suppler on tb_product.suppler=tb_suppler.id	where tb_in.id=?";
			//ResultSet rs=DbUtils.exeque(sql, id);
			ResultSet rs=DbUtils.exeque(sql, id);
		
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
				
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.fin();
			}
			return in;
	}
//添加商品
	@Override
	public int addInpay(Inpay inpay) {
		if(inpay==null){
			throw new RuntimeException("传入数据无效");
		}
		if(inpay.getIn()==null){
			throw new RuntimeException("传入数据无效");
		}
		int row=0;
		String sql="insert into tb_inpay(id,in_id,suppleyname,paymoney,balance,paydate,operator,allwebpersion,inmoney,memo) values(?,?,?,?,?,?,?,?,?,?)";
		String sql2="update tb_in set balance=?,closeaccount=? where id=? ";
		Connection conn=DbUtils.getcon();
		PreparedStatement ps1=null;
		PreparedStatement ps2=null;
		try {
			//设置事物
			conn.setAutoCommit(false);
			ps1=conn.prepareStatement(sql);
			ps2=conn.prepareStatement(sql2);
			//给占位参数赋值
			DbUtils.setpreparement(ps1, inpay.getId(),inpay.getIn().getId(),inpay.getSuppleyname(),
					inpay.getPaymoney(),inpay.getBalance(),inpay.getPaydate(),inpay.getOperator(),
					inpay.getAllwebpersion(),inpay.getInmoney(),inpay.getMemo());
			String closeaccount=inpay.getBalance()>0?"否":"是";
			DbUtils.setpreparement(ps2, inpay.getBalance(),closeaccount,inpay.getIn().getId());
			ps1.executeUpdate();
			ps2.executeUpdate();
			//成功提交
			conn.commit();
			row=1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {//失败回滚
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				//关闭资源
				DbUtils.closeResult(ps1, conn);
				DbUtils.closeResult(ps2, conn);
			}
		}
		
		return row;
	}
	//获取上入库结账商品最大id
	@Override
	public String finallMaxid() {
		String sql="select max(id) from tb_inpay";
		ResultSet rs = DbUtils.exeque(sql);
		String maxId=null;
		try {
			if(rs.next()){
				maxId=rs.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxId;
	}
	@SuppressWarnings({ "null", "null" })
	@Override
	public List<Inpay> finallyinpay() {
		List<Inpay> listp=new ArrayList<Inpay>();
		Inpay inp;
		//In in=null;
		Product pro=null;
		String sql="select * from tb_inpay";
		//String sql2="select productname from tb_in,tb_product where tb_in.product=tb_product.id and tb_in.id=?";
		String sql2=" select productname from tb_in left join tb_product on tb_in.product=tb_product.id  where  tb_in.id=?";
		ResultSet rs = DbUtils.exeque(sql);
		try {
			while(rs.next()){
				inp=new  Inpay(rs.getString(1),rs.getString(3),rs.getDouble(4),rs.getDouble(5),
						rs.getDate(6),rs.getString(7),rs.getString(8),rs.getDouble(9),rs.getString(10));
				ResultSet rs2 = DbUtils.exeque(sql2, rs.getString(2));
				if(rs2.next()){
					pro=new Product(rs2.getString("productname"));
				}
				
				inp.setProduct(pro);
				listp.add(inp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DbUtils.fin();
		}
		return listp;
	}
	@Override
	public List<Inpay> finallyinpaylike(Map<String, Object> produ) {
		if(produ==null){
			throw new RuntimeException("数据无效");
		}
		List<Inpay> list=new ArrayList<Inpay>();
		if(produ.size()==0){
			String produkey=null;
			String  value = null;
			for (Map.Entry<String, Object> inpa : produ.entrySet()) {
				produkey= inpa.getKey();
				value =(String) inpa.getValue();
				
			}
			Inpay inp;
			Product pro=null;
			//Inpay inp;
			String sql="select * from tb_inpay left join tb_in on " +
					"tb_inpay.in_id =tb_in.id left join tb_product on " +
					"tb_in.product=tb_product.id where "+produ+" like ?";
			String sql2=" select productname from tb_in left join tb_product on tb_in.product=tb_product.id  where  tb_in.id=?";
			
			ResultSet rs = DbUtils.exeque(sql, "%"+value+"%");
			/*try {
				/*while(rs.next()){
					inp=new  Inpay(rs.getString(1),rs.getString(3),rs.getDouble(4),rs.getDouble(5),
							rs.getDate(6),rs.getString(7),rs.getString(8),rs.getDouble(9),rs.getString(10));
					ResultSet rs2 = DbUtils.exeque(sql2, rs.getString(2));
					if(rs2.next()){
						pro=new Product(rs2.getString("productname"));
					}
					
					inp.setProduct(pro);
					list.add(inp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DbUtils.fin();
			}
		}*/
		
		
		
		
	}
		return list;

	}
}
