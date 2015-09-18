package com.uscms.bean;
/*************************************
 * 类名：班级类
 * 功能描述：提供班级信息
 * 作者：骆金
 * 创建日期：2015-9-8  
 * 版本：1.0.0.0
 *************************************/
public class StudentClass extends AbsObject {
	private String number="";//编号 
	private Integer count=0;//学生人数
	private Special mySpecial=null;//所在专业
	private String charger="";//班主任
	private String classRoom="";//责任教室
	private String memo="";//备注  
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Special getMySpecial() {
		return mySpecial;
	}
	public void setMySpecial(Special mySpecial) {
		this.mySpecial = mySpecial;
	}
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
	}
	public String getClassRoom() {
		return classRoom;
	}
	public void setClassRoom(String classRoom) {
		this.classRoom = classRoom;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
