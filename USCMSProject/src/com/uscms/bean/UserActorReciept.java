package com.uscms.bean;

import java.util.Date;
import java.util.Set;
/*用户角色分配单*/
public class UserActorReciept extends AbsObject {
	private Date setDate;//分配日期
	private Users user=null;//用户
	private Set<Actor> actors=null;//角色
	private String description="";//说明
	private Users worker=null;//经办人
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
	public Set<Actor> getActors() {
		return actors;
	}
	public void setActors(Set<Actor> actors) {
		this.actors = actors;
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
