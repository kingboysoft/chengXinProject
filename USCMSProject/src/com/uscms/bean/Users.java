package com.uscms.bean;

import java.util.Set;  
public class Users extends AbsObject {
	private String nickName;//昵称
	private String number;//账号
	private String password="";//密码
	private String state;//状态
	private String description;//角色描述
	private Set<Actor> myActors=null;//用户拥有的角色
	private Set<SystemMenu> myPowers=null;//拥有的系统权限
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Actor> getMyActors() {
		return myActors;
	}
	public void setMyActors(Set<Actor> myActors) {
		this.myActors = myActors;
	}
	public Set<SystemMenu> getMyPowers() {
		return myPowers;
	}
	public void setMyPowers(Set<SystemMenu> myPowers) {
		this.myPowers = myPowers;
	}
}
