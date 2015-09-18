package com.uscms.bean;

import java.util.Date;
 

public class UsersLog extends AbsObject {
	private String ipAddress;//地址
	private Users user;//用户
	private Date date;//日期 
	private String result;//操作结果
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
