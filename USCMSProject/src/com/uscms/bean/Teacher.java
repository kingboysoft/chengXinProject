package com.uscms.bean;

/***********************************
 * 类名：教师类
 * 功能：提供教师信息
 * 作者：徐志巍
 ************************************/
public class Teacher extends AbsHuman {
	private String profession;//职业类型
	private Organization org;//所属部门

	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public Organization getOrg() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org = org;
	} 
}
