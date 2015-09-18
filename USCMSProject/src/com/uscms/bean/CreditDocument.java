package com.uscms.bean;

import java.util.Date;
import java.util.Set;
/* *******************************
* 类名：诚信档案类   
* 功能:诚信档案类属性及属性方法
* 作者：林康生
* 版本:1.0.0.0 
* 时间:2015/9/8 9:37
* *********************************/
public class CreditDocument extends AbsObject {
	private String code;// 档案编号
	private Date createDate;//建档日期 
	private Student myself=null;// 建档学生
	private Integer score=0;// 诚信分值  
	private String level;//诚信等级
	private Set<CreditType> items;// 诚信票据项
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Student getMyself() {
		return myself;
	}
	public void setMyself(Student myself) {
		this.myself = myself;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Set<CreditType> getItems() {
		return items;
	}
	public void setItems(Set<CreditType> items) {
		this.items = items;
	}
	
	
}
