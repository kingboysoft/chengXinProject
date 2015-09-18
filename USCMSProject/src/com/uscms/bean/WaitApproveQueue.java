package com.uscms.bean;
/************************************
 * 类名：待审批队列类
 * 功能描述：提供待审批队列信息
 * 作者：骆金
 * 创建日期：2015-9-8  
 * 版本：1.0.0.0
 **************************************/
import java.util.Queue; 
public class WaitApproveQueue extends AbsObject {
    private String number="";//队列号 
    private Actor myActors=null;//审批角色
    private Queue<CreditRecieptRecord> myTickets=null;//待审批单据
    private Integer count=0;//待审批票据数；
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Actor getMyActors() {
		return myActors;
	}
	public void setMyActors(Actor myActors) {
		this.myActors = myActors;
	}
	public Queue<CreditRecieptRecord> getMyTickets() {
		return myTickets;
	}
	public void setMyTickets(Queue<CreditRecieptRecord> myTickets) {
		this.myTickets = myTickets;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
     
}
