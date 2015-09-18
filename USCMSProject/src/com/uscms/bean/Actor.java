package com.uscms.bean;

import java.util.Set;

/*
 * 系统角色
 */
public class Actor extends AbsObject {
	private String code="";//角色编号
	private String description="";//角色说明
	private Actor parent=null;//上级角色
	private Set<Actor> children=null;//子角�?
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Actor getParent() {
		return parent;
	}
	public void setParent(Actor parent) {
		this.parent = parent;
	}
	public Set<Actor> getChildren() {
		return children;
	}
	public void setChildren(Set<Actor> children) {
		this.children = children;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
