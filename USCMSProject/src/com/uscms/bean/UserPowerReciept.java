package com.uscms.bean;

import java.util.Date;
import java.util.Set; 
/*用户系统授权单*/
public class UserPowerReciept extends AbsObject {
	private Date setDate;//授权日期
	private Users user=null;//用户
	private Set<SystemMenu> powers=null;//权限
	private String description="";//备注
	private Users worker=null;//授权人
	public Date getSetDate() {
		return setDate;
	}
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Set<SystemMenu> getPowers() {
		return powers;
	}
	public void setPowers(Set<SystemMenu> powers) {
		this.powers = powers;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Users getWorker() {
		return worker;
	}
	public void setWorker(Users worker) {
		this.worker = worker;
	}
}
