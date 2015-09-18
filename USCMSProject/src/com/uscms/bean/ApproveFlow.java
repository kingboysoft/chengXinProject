package com.uscms.bean;

import java.util.Set;

/*审批流程*/
public class ApproveFlow extends AbsObject {
	private CreditType type;//诚信票据类型
	private Set<ApproveFlowItem> nodes;//审批节点
	private String description="";//说明
	public CreditType getType() {
		return type;
	}
	public void setType(CreditType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<ApproveFlowItem> getNodes() {
		return nodes;
	}
	public void setNodes(Set<ApproveFlowItem> nodes) {
		this.nodes = nodes;
	}

}
