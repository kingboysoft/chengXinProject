package com.uscms.bean;

import java.util.Set;
 
public class Organization extends AbsObject {
	private String number="";//编号
	private String description="";//描述 
	private String charger="";//负责人
	private String url="";//官方网址
	private Organization parent;//上级机构
	private Set<Organization> children=null;
	private String property="";//性质
	private Boolean isUnit=false;//是否为独立机构，true表示是，false表示普通部门
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCharger() {
		return charger;
	}
	public void setCharger(String charger) {
		this.charger = charger;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Organization getParent() {
		return parent;
	}
	public void setParent(Organization parent) {
		this.parent = parent;
	}
	public Set<Organization> getChildren() {
		return children;
	}
	public void setChildren(Set<Organization> children) {
		this.children = children;
	}
	public String getProperty() {
		return property;
	}
	public void setProperty(String property) {
		this.property = property;
	}
	public Boolean getIsUnit() {
		return isUnit;
	}
	public void setIsUnit(Boolean isUnit) {
		this.isUnit = isUnit;
	}
}
