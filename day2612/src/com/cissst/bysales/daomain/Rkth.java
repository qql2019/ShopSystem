package com.cissst.bysales.daomain;

import java.io.Serializable;
import java.sql.Date;

public class Rkth implements Serializable {
private String id;//标志属性
private In in;//入库实体
private String productname;//商品名
private String supplername;//供应商
private double productprice;//入库单价
private double productmoney;//退货商品金额
private Date rkthdate;//退货时间
private String operator;//操作员
private String allowebperson;//批准人
private double unpaymoney;//未付金额
private String closeaccount;//是否结清
private int productnum;//退货数量
private String memo;//备注
public Rkth(String id, String productname, String supplername,
		double productprice, double productmoney, Date rkthdate,
		String operator, String allowebperson, double unpaymoney,
		String closeaccount, int productnum, String memo) {
	super();
	this.id = id;
	this.productname = productname;
	this.supplername = supplername;
	this.productprice = productprice;
	this.productmoney = productmoney;
	this.rkthdate = rkthdate;
	this.operator = operator;
	this.allowebperson = allowebperson;
	this.unpaymoney = unpaymoney;
	this.closeaccount = closeaccount;
	this.productnum = productnum;
	this.memo = memo;
}
public Rkth() {

}
public String getId() {
	return id;
}
public void setId(String id) {
	this.id = id;
}
public In getIn() {
	return in;
}
public void setIn(In in) {
	this.in = in;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public String getSupplername() {
	return supplername;
}
public void setSupplername(String supplername) {
	this.supplername = supplername;
}
public double getProductprice() {
	return productprice;
}
public void setProductprice(double productprice) {
	this.productprice = productprice;
}
public double getProductmoney() {
	return productmoney;
}
public void setProductmoney(double productmoney) {
	this.productmoney = productmoney;
}
public Date getRkthdate() {
	return rkthdate;
}
public void setRkthdate(Date rkthdate) {
	this.rkthdate = rkthdate;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public String getAllowebperson() {
	return allowebperson;
}
public void setAllowebperson(String allowebperson) {
	this.allowebperson = allowebperson;
}
public double getUnpaymoney() {
	return unpaymoney;
}
public void setUnpaymoney(double unpaymoney) {
	this.unpaymoney = unpaymoney;
}
public String getCloseaccount() {
	return closeaccount;
}
public void setCloseaccount(String closeaccount) {
	this.closeaccount = closeaccount;
}
public int getProductnum() {
	return productnum;
}
public void setProductnum(int productnum) {
	this.productnum = productnum;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}




}
