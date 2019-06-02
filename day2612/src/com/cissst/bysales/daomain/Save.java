package com.cissst.bysales.daomain;

import java.io.Serializable;

//库存
public class Save implements Serializable {
private int id;//标识
private Product product;//商品
private int productnum;//库存商品
private double productprice;//库存商品单价
private double productmoney;//该库存商品总价
private String memo;//备注
public Save() {
	super();
	// TODO Auto-generated constructor stub
}
public Save(int id, int productnum, double productprice, double productmoney,
		String memo) {
	super();
	this.id = id;
	this.productnum = productnum;
	this.productprice = productprice;
	this.productmoney = productmoney;
	this.memo = memo;
}
public Save(int productnum, double productprice, double productmoney,
		String memo) {
	super();
	this.productnum = productnum;
	this.productprice = productprice;
	this.productmoney = productmoney;
	this.memo = memo;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public int getProductnum() {
	return productnum;
}
public void setProductnum(int productnum) {
	this.productnum = productnum;
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
public String getMemo() {
	return memo;
}
public void setMemo(String memo) {
	this.memo = memo;
}

}
