package com.uscms.bean;

/***************************
 * 类名：诚信种类 
 * 功能：负责诚信票据的种类操作
 * 作者：刘孔河
 * 时间：2015-09-08 10:20:31
 * **************************/
public class CreditType extends AbsObject {
	private String code="";//种类编号 
	private String description="";//种类描述
	private Float proportion=0f;//分值
	private String rule="";//计分规则
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Float getProportion() {
		return proportion;
	}
	public void setProportion(Float proportion) {
		this.proportion = proportion;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	
}
