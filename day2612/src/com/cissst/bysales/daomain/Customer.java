package com.cissst.bysales.daomain;

import java.io.Serializable;

/**
 * 用户实体类
 * @author Administrator
 *
 */
public class Customer implements Serializable {
	private int id;//编号
	private String custname;//姓名
	private String custattr;//住址
	private String custtel;//电话
	private String custpersion;//联系人
	private String custpertel;//联系人电话
	private String custfax;//传真
	private String custemail;//邮箱
	private String custQQ;//QQ
	private String custbank;//开户银行
	private String custaccountno;//开户账户
	private String custmeno;//备注
	private String custpostcod;//邮编
	
	
	public Customer() {
		super();
	}


	public Customer(int id, String custname, String custattr, String custtel,
			String custpersion, String custpertel, String custfax,
			String custemail, String custQQ, String custbank,
			String custaccountno, String custmeno, String custpostcod) {
		super();
		this.id = id;
		this.custname = custname;
		this.custattr = custattr;
		this.custtel = custtel;
		this.custpersion = custpersion;
		this.custpertel = custpertel;
		this.custfax = custfax;
		this.custemail = custemail;
		this.custQQ = custQQ;
		this.custbank = custbank;
		this.custaccountno = custaccountno;
		this.custmeno = custmeno;
		this.custpostcod = custpostcod;
	}


	public Customer(String custname, String custattr, String custtel,
			String custpersion, String custpertel, String custfax,
			String custemail, String custQQ, String custbank,
			String custaccountno, String custmeno, String custpostcod) {
		super();
		this.custname = custname;
		this.custattr = custattr;
		this.custtel = custtel;
		this.custpersion = custpersion;
		this.custpertel = custpertel;
		this.custfax = custfax;
		this.custemail = custemail;
		this.custQQ = custQQ;
		this.custbank = custbank;
		this.custaccountno = custaccountno;
		this.custmeno = custmeno;
		this.custpostcod = custpostcod;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCustname() {
		return custname;
	}


	public void setCustname(String custname) {
		this.custname = custname;
	}


	public String getCustattr() {
		return custattr;
	}


	public void setCustattr(String custattr) {
		this.custattr = custattr;
	}


	public String getCusttel() {
		return custtel;
	}


	public void setCusttel(String custtel) {
		this.custtel = custtel;
	}


	public String getCustpersion() {
		return custpersion;
	}


	public void setCustpersion(String custpersion) {
		this.custpersion = custpersion;
	}


	public String getCustpertel() {
		return custpertel;
	}


	public void setCustpertel(String custpertel) {
		this.custpertel = custpertel;
	}


	public String getCustfax() {
		return custfax;
	}


	public void setCustfax(String custfax) {
		this.custfax = custfax;
	}


	public String getCustemail() {
		return custemail;
	}


	public void setCustemail(String custemail) {
		this.custemail = custemail;
	}


	public String getCustQQ() {
		return custQQ;
	}


	public void setCustQQ(String custQQ) {
		this.custQQ = custQQ;
	}


	public String getCustbank() {
		return custbank;
	}


	public void setCustbank(String custbank) {
		this.custbank = custbank;
	}


	public String getCustaccountno() {
		return custaccountno;
	}


	public void setCustaccountno(String custaccountno) {
		this.custaccountno = custaccountno;
	}


	public String getCustmeno() {
		return custmeno;
	}


	public void setCustmeno(String custmeno) {
		this.custmeno = custmeno;
	}


	public String getCustpostcod() {
		return custpostcod;
	}


	public void setCustpostcod(String custpostcod) {
		this.custpostcod = custpostcod;
	}
	
	
}
