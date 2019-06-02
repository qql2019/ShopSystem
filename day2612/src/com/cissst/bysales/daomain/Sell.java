package com.cissst.bysales.daomain;

import java.io.Serializable;
import java.sql.Date;

//销售实体
public class Sell implements Serializable {
private String id;//标志属性
private Product product;//商品
private double productPrice;//销售单价
private int productnum;//销售数量
private double productmoney;//销售金额
private Customer customer;//客户
private Date selldate;//销售时间
private String operator;//操作人
private String allwebperson;//批准人
private String memo;//备注
private double sellbalan;//销售欠款
private String closeaccount;//是否结清
public Sell() {
	
}
public Sell(String id, double productPrice, int productnum,
		double productmoney, Date selldate, String operator,
		String allwebperson, String memo,double sellbalan,String closeaccount) {

	this.id = id;
	this.productPrice = productPrice;
	this.productnum = productnum;
	this.productmoney = productmoney;
	this.selldate = selldate;
	this.operator = operator;
	this.allwebperson = allwebperson;
	this.memo = memo;
	this.sellbalan=sellbalan;
	this.closeaccount=closeaccount;
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
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}
public int getProductnum() {
	return productnum;
}
public void setProductnum(int productnum) {
	this.productnum = productnum;
}
public double getProductmoney() {
	return productmoney;
}
public void setProductmoney(double productmoney) {
	this.productmoney = productmoney;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public Date getSelldate() {
	return selldate;
}
public void setSelldate(Date selldate) {
	this.selldate = selldate;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public String getAllwebperson() {
	return allwebperson;
}
public void setAllwebperson(String allwebperson) {
	this.allwebperson = allwebperson;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public double getSellbalan() {
	return sellbalan;
}
public void setSellbalan(double sellbalan) {
	this.sellbalan = sellbalan;
}
public String getCloseaccount() {
	return closeaccount;
}
public void setCloseaccount(String closeaccount) {
	this.closeaccount = closeaccount;
}






}
