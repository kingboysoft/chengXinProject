package com.uscms.bean;

import java.util.Date;
/* *******************************
* 类名：诚信申诉单   
* 功能:诚信申诉单类属性及属性方法
* 作者：林康生
* 版本:1.0.0.0 
* 时间:2015/9/8 11:37
* *********************************/
 
public class CreditApplyReciept extends AbsObject {
	private String code;// 单号
	private CreditReciept reciept;//申诉的诚信票据 
	private String suggestion; //意见
	private String result;//申诉结果
	private Date theTime;// 申诉时间
	private Date approvalTime;//审批时间
	private String proofAtt="";//申诉证据附件
	private Users applier;//申诉人
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public CreditReciept getReciept() {
		return reciept;
	}
	public void setReciept(CreditReciept reciept) {
		this.reciept = reciept;
	}
	public String getSuggestion() {
		return suggestion;
	}
	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getTheTime() {
		return theTime;
	}
	public void setTheTime(Date theTime) {
		this.theTime = theTime;
	}
	public Date getApprovalTime() {
		return approvalTime;
	}
	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}
	public String getProofAtt() {
		return proofAtt;
	}
	public void setProofAtt(String proofAtt) {
		this.proofAtt = proofAtt;
	}
	public Users getApplier() {
		return applier;
	}
	public void setApplier(Users applier) {
		this.applier = applier;
	}
	 
}
