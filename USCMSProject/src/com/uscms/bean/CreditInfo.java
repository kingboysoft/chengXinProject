package com.uscms.bean;

import java.util.Date;

/*********************************
 * 类名：诚信数据提醒
 * 功能：出现诚信数据时，进行提醒
 * 作者：徐志巍
 *********************************/
public class CreditInfo extends AbsObject {
	private String number = "";//编号
	private String content = "";//消息内容
	private Users reciever=null;//消息接收者
	private Date sendDate;//消息发送日期
	private Date doDate;//消息处理日期
	private String result="";//处理说明
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Users getReciever() {
		return reciever;
	}
	public void setReciever(Users reciever) {
		this.reciever = reciever;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Date getDoDate() {
		return doDate;
	}
	public void setDoDate(Date doDate) {
		this.doDate = doDate;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	} 
}
