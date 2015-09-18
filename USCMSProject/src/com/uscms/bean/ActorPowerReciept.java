package com.uscms.bean;

import java.util.Date;
import java.util.Set;
/*角色系统权限授权单*/
public class ActorPowerReciept extends AbsObject {
	private Date setDate;//授权日期
	private Actor actor=null;//角色 
	private Set<SystemMenu> powers=null;//权限
	private String description="";//备注
	private Users worker=null;//授权人
	public Date getSetDate() {
		return setDate;
	}
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
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
