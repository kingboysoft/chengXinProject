package com.uscms.bean;
/***********************************
 * 类名：已审批队列类
 * 功能描述：提供已审批队列信息
 * 作者：骆金
 * 创建日期：2015-9-8  
 * 版本：1.0.0.0
 **************************************/
 
import java.util.Set;

public class ApprovedQueue extends AbsObject {
	private String number="";//审批编号 
	private Users approver=null;//审批人
	private Set<ApproveAdviceReciept> reciepts=null;//已审批的票据
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Users getApprover() {
		return approver;
	}
	public void setApprover(Users approver) {
		this.approver = approver;
	}
	public Set<ApproveAdviceReciept> getReciepts() {
		return reciepts;
	}
	public void setReciepts(Set<ApproveAdviceReciept> reciepts) {
		this.reciepts = reciepts;
	}
	 
}
