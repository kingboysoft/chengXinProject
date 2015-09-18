package com.uscms.bean; 
import java.util.Set;  
public class Dictionary extends AbsObject {
	private String number="";//编号
	private String type="";//分类名称
	private String description="";//解释描述
	private String keyword="";//关键字
	private Dictionary parent=null;//上级目录
	private Set<Dictionary> children=null;//直接子目录
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Dictionary getParent() {
		return parent;
	}
	public void setParent(Dictionary parent) {
		this.parent = parent;
	}
	public Set<Dictionary> getChildren() {
		return children;
	}
	public void setChildren(Set<Dictionary> children) {
		this.children = children;
	}
}
