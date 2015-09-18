package com.uscms.bean;

import java.util.Set;

/*
 *角色诚信票据填写分配单 
 **/
public class ActorOfCreditType extends AbsObject {
	private Actor actor=null;//角色
	private Set<CreditType> creditTypes=null;//票据类型
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public Set<CreditType> getCreditTypes() {
		return creditTypes;
	}
	public void setCreditTypes(Set<CreditType> creditTypes) {
		this.creditTypes = creditTypes;
	}

}
