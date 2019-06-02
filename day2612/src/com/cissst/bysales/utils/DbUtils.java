package com.cissst.bysales.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbUtils {
	private static String driver="oracle.jdbc.driver.OracleDriver";
	private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	private static String user="scott";
	private static String password="oracle";
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	//加载驱动
	static{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//建立连接
	public static Connection getcon(){
		try {
			conn=DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static PreparedStatement getps(String sql,Object...arg){
		getcon();
		try {
			ps=conn.prepareStatement(sql);
			for (int i = 0; i < arg.length; i++) {
				ps.setObject(i+1, arg[i]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	public static ResultSet exeque(String sql,Object...arg){
		getps(sql,arg);
		try {
			rs=ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static int exequeupdate(String sql,Object...arg){
		getps(sql,arg);
		int row=0;
		try {
			row=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return row;
	}
	//关系到事务的方法
	public static void setpreparement(PreparedStatement ps,Object...arg){
		if(ps==null){
			throw new RuntimeException("无传入参数");
		}
		if(arg!=null&&arg.length>0){
			for (int i = 0; i < arg.length; i++) {
				try {
					ps.setObject(i+1, arg[i]);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void fin(){
		try {
			if(rs!=null){
			rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeResult(PreparedStatement ps,Connection con){
		
			try {
				if(ps!=null){
				ps.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	public static void main(String[] args) {
		String sql="select * from dept";
		ResultSet rs = DbUtils.exeque(sql);
		try {
			while(rs.next()){
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
