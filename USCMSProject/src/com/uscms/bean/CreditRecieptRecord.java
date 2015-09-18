package com.uscms.bean;

import java.util.Date;

/**
 *诚信票据审批递交单 
 */
public class CreditRecieptRecord {
	private CreditReciept reciept=null;//诚信票据
	private Date sendDate;//传送日期
	private Users sender=null;//传送者
	private Date doDate;//处理时间
	private Users doUsers=null;//处理用户
	public CreditReciept getReciept() {
		return reciept;
	}
	public void setReciept(CreditReciept reciept) {
		this.reciept = reciept;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Users getSender() {
		return sender;
	}
	public void setSender(Users sender) {
		this.sender = sender;
	}
	public Date getDoDate() {
		return doDate;
	}
	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}
	public Users getDoUsers() {
		return doUsers;
	}
	public void setDoUsers(Users doUsers) {
		this.doUsers = doUsers;
	}

}
