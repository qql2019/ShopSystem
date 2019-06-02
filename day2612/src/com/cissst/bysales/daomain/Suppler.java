package com.cissst.bysales.daomain;

import java.io.Serializable;

/**
 * 供应商实体类
 * @author Administrator
 *
 */
public class Suppler implements Serializable {
private int id;//编号
private String supplername;//姓名
private String suppleraddr;//住址
private String supplertel;//电话
private String supplerper;//联系人
private String supplerphone;//联系方式
private String supplerEmal;//邮箱
private String supplerQQ;//QQ
private String supplerpost;//邮编
private String supplerfax;//传真
private String supplerbank;//开户银行
private String suppleraccounton;//卡号
private String supplermeno;//备注

public Suppler() {
	super();
	// TODO Auto-generated constructor stub
}

public Suppler(int id, String supplername, String suppleraddr,
		String supplertel, String supplerper, String supplerphone,
		String supplerEmal, String supplerQQ, String supplerpost,
		String supplerfax, String supplerbank, String suppleraccounton,
		String supplermeno) {
	super();
	this.id = id;
	this.supplername = supplername;
	this.suppleraddr = suppleraddr;
	this.supplertel = supplertel;
	this.supplerper = supplerper;
	this.supplerphone = supplerphone;
	this.supplerEmal = supplerEmal;
	this.supplerQQ = supplerQQ;
	this.supplerpost = supplerpost;
	this.supplerfax = supplerfax;
	this.supplerbank = supplerbank;
	this.suppleraccounton = suppleraccounton;
	this.supplermeno = supplermeno;
}

public Suppler(String supplername, String suppleraddr, String supplertel,
		String supplerper, String supplerphone, String supplerEmal,
		String supplerQQ, String supplerpost, String supplerfax,
		String supplerbank, String suppleraccounton, String supplermeno) {
	super();
	this.supplername = supplername;
	this.suppleraddr = suppleraddr;
	this.supplertel = supplertel;
	this.supplerper = supplerper;
	this.supplerphone = supplerphone;
	this.supplerEmal = supplerEmal;
	this.supplerQQ = supplerQQ;
	this.supplerpost = supplerpost;
	this.supplerfax = supplerfax;
	this.supplerbank = supplerbank;
	this.suppleraccounton = suppleraccounton;
	this.supplermeno = supplermeno;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getSupplername() {
	return supplername;
}

public void setSupplername(String supplername) {
	this.supplername = supplername;
}

public String getSuppleraddr() {
	return suppleraddr;
}

public void setSuppleraddr(String suppleraddr) {
	this.suppleraddr = suppleraddr;
}

public String getSupplertel() {
	return supplertel;
}

public void setSupplertel(String supplertel) {
	this.supplertel = supplertel;
}

public String getSupplerper() {
	return supplerper;
}

public void setSupplerper(String supplerper) {
	this.supplerper = supplerper;
}

public String getSupplerphone() {
	return supplerphone;
}

public void setSupplerphone(String supplerphone) {
	this.supplerphone = supplerphone;
}

public String getSupplerEmal() {
	return supplerEmal;
}

public void setSupplerEmal(String supplerEmal) {
	this.supplerEmal = supplerEmal;
}

public String getSupplerQQ() {
	return supplerQQ;
}

public void setSupplerQQ(String supplerQQ) {
	this.supplerQQ = supplerQQ;
}

public String getSupplerpost() {
	return supplerpost;
}

public void setSupplerpost(String supplerpost) {
	this.supplerpost = supplerpost;
}

public String getSupplerfax() {
	return supplerfax;
}

public void setSupplerfax(String supplerfax) {
	this.supplerfax = supplerfax;
}

public String getSupplerbank() {
	return supplerbank;
}

public void setSupplerbank(String supplerbank) {
	this.supplerbank = supplerbank;
}

public String getSuppleraccounton() {
	return suppleraccounton;
}

public void setSuppleraccounton(String suppleraccounton) {
	this.suppleraccounton = suppleraccounton;
}

public String getSupplermeno() {
	return supplermeno;
}

public void setSupplermeno(String supplermeno) {
	this.supplermeno = supplermeno;
}

}
