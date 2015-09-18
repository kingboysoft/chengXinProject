package com.uscms.bean;

import java.util.Date;

/********************************************************
 * 类名：审批意见类
 * 功能描述：描述审批意见的属性及功能
 * 作者：熊凯
 * 时间：2015-9-9
 ******************************************************/
public class ApproveAdviceReciept extends AbsObject {
	private String number="";//审批意见单编号 
	private Date starDate=null;//时间
	private String details="";//意见内容
	private Users worker=null;//意见人
	private CreditReciept bill=null;//诚信票据
	private String result="";//审批结果
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getStarDate() {
		return starDate;
	}
	public void setStarDate(Date starDate) {
		this.starDate = starDate;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Users getWorker() {
		return worker;
	}
	public void setWorker(Users worker) {
		this.worker = worker;
	}
	public CreditReciept getBill() {
		return bill;
	}
	public void setBill(CreditReciept bill) {
		this.bill = bill;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
