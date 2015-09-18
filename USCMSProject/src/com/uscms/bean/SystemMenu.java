package com.uscms.bean;

import java.util.Set; 

public class SystemMenu extends AbsObject {
	private String number="";//菜单编号
	private String address="";//权限菜单存放地址 
	private String description="";//权限描述
	private SystemMenu parent=null;//上级权限
	private Set<SystemMenu> children=null;//子级权限
	private boolean open=true;//是否开启
	private Integer order=0;//菜单权限显示序号
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public SystemMenu getParent() {
		return parent;
	}
	public void setParent(SystemMenu parent) {
		this.parent = parent;
	}
	public Set<SystemMenu> getChildren() {
		return children;
	}
	public void setChildren(Set<SystemMenu> children) {
		this.children = children;
	}
	public boolean isOpen() {
		return open;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
}
