package com.cissst.bysales.daomain;

import java.sql.Date;
//入库结账实体
public class Inpay {
private String id;
private In in;//入库实体
private String suppleyname;//供应商
private double paymoney;//本次应付款
private double balance;//剩余款
private Date paydate;//付款时间
private String operator;//操作人
private String allwebpersion;//审批人
private double inmoney;//应付款
private String memo;//备注
private Product product;
public Inpay() {
	super();
	// TODO Auto-generated constructor stub
}
public Inpay(String id, String suppleyname, double paymoney, double balance,
		Date paydate, String operator, String allwebpersion, double inmoney,
		String memo) {
	super();
	this.id = id;
	this.suppleyname = suppleyname;
	this.paymoney = paymoney;
	this.balance = balance;
	this.paydate = paydate;
	this.operator = operator;
	this.allwebpersion = allwebpersion;
	this.inmoney = inmoney;
	this.memo = memo;
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
public String getSuppleyname() {
	return suppleyname;
}
public void setSuppleyname(String suppleyname) {
	this.suppleyname = suppleyname;
}
public double getPaymoney() {
	return paymoney;
}
public void setPaymoney(double paymoney) {
	this.paymoney = paymoney;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public Date getPaydate() {
	return paydate;
}
public void setPaydate(Date paydate) {
	this.paydate = paydate;
}
public String getOperator() {
	return operator;
}
public void setOperator(String operator) {
	this.operator = operator;
}
public String getAllwebpersion() {
	return allwebpersion;
}
public void setAllwebpersion(String allwebpersion) {
	this.allwebpersion = allwebpersion;
}
public double getInmoney() {
	return inmoney;
}
public void setInmoney(double inmoney) {
	this.inmoney = inmoney;
}
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}






}
