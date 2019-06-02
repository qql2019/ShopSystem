package com.cissst.bysales.daomain;

import java.io.Serializable;
import java.sql.Date;

//仓库实体类
public class In implements Serializable {
	private String id;// 标识
	private Product product;// 库存商品
	private double inprice;// 库单价
	private int innum;// 库数量
	private double inmeny;// 商品入库金额
	private Date indate;// 入库时间
	private String persnon;// 入库人
	private String inallperson;// 批准人
	private double balance;// 欠款
	private String closeaccount;// 是否结清
	private String memo;// 备注
	private String supplername;//供应商名
	private String productname;
	public In() {
		
	}

	public In(String id, double inprice, int innum, double inmeny, Date indate,
			String persnon, String inallperson, double balance,
			String closeaccount, String memo) {
		super();
		this.id = id;
		this.inprice = inprice;
		this.innum = innum;
		this.inmeny = inmeny;
		this.indate = indate;
		this.persnon = persnon;
		this.inallperson = inallperson;
		this.balance = balance;
		this.closeaccount = closeaccount;
		this.memo = memo;
	}

	public In(double inprice, int innum, double inmeny, Date indate,
			String persnon, String inallperson, double balance,
			String closeaccount, String memo) {
		super();
		this.inprice = inprice;
		this.innum = innum;
		this.inmeny = inmeny;
		this.indate = indate;
		this.persnon = persnon;
		this.inallperson = inallperson;
		this.balance = balance;
		this.closeaccount = closeaccount;
		this.memo = memo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getInprice() {
		return inprice;
	}

	public void setInprice(double inprice) {
		this.inprice = inprice;
	}

	public int getInnum() {
		return innum;
	}

	public void setInnum(int innum) {
		this.innum = innum;
	}

	public double getInmeny() {
		return inmeny;
	}

	public void setInmeny(double inmeny) {
		this.inmeny = inmeny;
	}

	public Date getIndate() {
		return indate;
	}

	public void setIndate(Date indate) {
		this.indate = indate;
	}

	public String getPersnon() {
		return persnon;
	}

	public void setPersnon(String persnon) {
		this.persnon = persnon;
	}

	public String getInallperson() {
		return inallperson;
	}

	public void setInallperson(String inallperson) {
		this.inallperson = inallperson;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getCloseaccount() {
		return closeaccount;
	}

	public void setCloseaccount(String closeaccount) {
		this.closeaccount = closeaccount;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getSupplername() {
		this.supplername=this.getProduct().getSuppler().getSupplername();
		return supplername;
	}

	public String getProductname() {
		this.productname=this.getProduct().getProductname();
		return productname;
	}

	
	
}
