package com.uscms.bean;

import java.util.Date;
import java.util.Set;
/***************************
 * 类名：诚信票据
 * 功能：提供诚信票据的各种操作
 * 作者：刘孔河
 * 时间：2015-09-08 10:20:31
 * **************************/
public class CreditReciept extends AbsObject {
	private String number="";//票据编号； 
	private CreditDocument document=null;//所属的诚信档案
	private CreditType creditType=null;//诚信种类 
	private Users worker=null;//经办人
	private String because="";//事件经过
	private Date startDate=null;//事件发生时间
	private String thing="";//事件主题
	private Date date=null;//填写日期
	private String remark="";//备注
	private String accessory="";//附件
	private Set<ApproveAdviceReciept> advices=null;//审批意见
	private Set<CreditApplyReciept> applies=null;//申诉单
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public CreditType getCreditType() {
		return creditType;
	}
	public void setCreditType(CreditType creditType) {
		this.creditType = creditType;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}	
	public Users getWorker() {
		return worker;
	}
	public void setWorker(Users worker) {
		this.worker = worker;
	}
	public String getBecause() {
		return because;
	}
	public void setBecause(String because) {
		this.because = because;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getThing() {
		return thing;
	}
	public void setThing(String thing) {
		this.thing = thing;
	}
	public String getAccessory() {
		return accessory;
	}
	public void setAccessory(String accessory) {
		this.accessory = accessory;
	}
	public CreditDocument getDocument() {
		return document;
	}
	public void setDocument(CreditDocument document) {
		this.document = document;
	}
	public Set<ApproveAdviceReciept> getAdvices() {
		return advices;
	}
	public void setAdvices(Set<ApproveAdviceReciept> advices) {
		this.advices = advices;
	}
	public Set<CreditApplyReciept> getApplies() {
		return applies;
	}
	public void setApplies(Set<CreditApplyReciept> applies) {
		this.applies = applies;
	}
	
	
}
