package com.cissst.bysales.daomain;

import java.io.Serializable;
import java.sql.Date;

/**
 * 商品实体类
 * 
 * @author Administrator
 * 
 */
public class Product implements Serializable {
	private int id;// 标示属性
	private String productno;// 编号
	private String productname;// 名称
	private String productauth;// 作者
	private double price;// 单价
	private int diskno;// 光盘
	private Suppler suppler;// 供应商
	private String supplernamestr;//供应商名称
	private String datestr;//
	private Date pubdate;// 出版日期
	private String memo;// 备注

	public Product() {

	}

	public Product(String productname) {
		super();
		this.productname = productname;
	}

	public Product(int id, String productno, String productname,
			String productauth, double price, int diskno, Date pubdate,
			String memo) {
		super();
		this.id = id;
		this.productno = productno;
		this.productname = productname;
		this.productauth = productauth;
		this.price = price;
		this.diskno = diskno;
		this.pubdate = pubdate;
		this.memo = memo;
	}

	public Product(String productno, String productname, String productauth,
			double price, int diskno, Date pubdate, String memo) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.productauth = productauth;
		this.price = price;
		this.diskno = diskno;
		this.pubdate = pubdate;
		this.memo = memo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductno() {
		return productno;
	}

	public void setProductno(String productno) {
		this.productno = productno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductauth() {
		return productauth;
	}

	public void setProductauth(String productauth) {
		this.productauth = productauth;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getDiskno() {
		return diskno;
	}

	public void setDiskno(int diskno) {
		this.diskno = diskno;
	}

	public Suppler getSuppler() {
		return suppler;
	}

	public void setSuppler(Suppler suppler) {
		this.suppler = suppler;
	}

	public Date getPubdate() {
		return pubdate;
	}

	public void setPubdate(Date pubdate) {
		this.pubdate = pubdate;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return productname ;
	}

	public String getSupplernamestr() {
		supplernamestr=this.suppler.getSupplername();
		return supplernamestr;
	}

	public void setSupplernamestr(String supplernamestr) {
		this.supplernamestr = supplernamestr;
	}

	public String getDatestr() {
		this.datestr=this.pubdate.toString();
		return datestr;
	}

	public void setDatestr(String datestr) {
		this.datestr = datestr;
	}

	

}
