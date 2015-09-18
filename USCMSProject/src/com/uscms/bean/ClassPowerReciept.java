package com.uscms.bean;

import java.util.Date;
import java.util.Set;
/**************************************************************
 * 类名：班级授权清单类
 * 功能描述：描述班级授权的属性
 * 作者：刘其忠
 * 创建日期：2015-9-8 
 * 版本号：1.0.0.0  
 *************************************************************/
public class ClassPowerReciept extends AbsObject {
	private Date setDate;//授权日期
	private Users worker=null;//授权人 
	private Set<StudentClass> classes=null;//班级    
	private Actor actor=null;//角色
	private String discription=null;//备注
	public Date getSetDate() {
		return setDate;
	} 
	public void setSetDate(Date setDate) {
		this.setDate = setDate;
	}
	public Users getWorker() {
		return worker;
	}
	public void setWorker(Users worker) {
		this.worker = worker;
	}
	public Set<StudentClass> getClasses() {
		return classes;
	}
	public void setClasses(Set<StudentClass> classes) {
		this.classes = classes;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
}
