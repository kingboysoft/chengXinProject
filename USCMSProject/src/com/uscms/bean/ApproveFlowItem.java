package com.uscms.bean; 
/***********************************
 *审批流程节点 
 ***********************************/
public class ApproveFlowItem extends AbsObject {
	private Actor actor=null;//审批角色
	private int order=-1;//审批序号
	private Number moneyPower=0;//最大金额审批权
	private String description="";//说明
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Number getMoneyPower() {
		return moneyPower;
	}
	public void setMoneyPower(Number moneyPower) {
		this.moneyPower = moneyPower;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
