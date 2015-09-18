package com.uscms.action;

import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext; 
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.uscms.util.Spring;

public class Actor extends ActionSupport implements ModelDriven<com.uscms.bean.Actor> {
	private String tips="";//操作提示
	private String data="";//交换的数据源
	private String condition="1=1";//查询条件
	private String parentId="";//父类角色ID；
	private int pageNumber=1;
	private int rowsCount=10;
	
	private com.uscms.bean.Actor actor=(com.uscms.bean.Actor)Spring.GetSpringObject("bean_actor");
	private com.uscms.service.impl.ActorImpl service=(com.uscms.service.impl.ActorImpl)Spring.GetSpringObject("actor");
	
	@Override
	public com.uscms.bean.Actor getModel() { 
		return actor;
	} 
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	/*****************************
	 *获取角色的Combobox数据源 
	 *****************************/
	public String actorCombJson()
	{ 
		java.util.List<String> fields=new java.util.ArrayList<String>();
		fields.add("id");
		fields.add("name");
		String result=com.uscms.util.Search.ToObjectJson(service.find(condition), fields);
		setData(result);
		return "success";
	}
	public String display(){
		setTips(actor.getName());
		return this.SUCCESS;
	}
	public String find()
	{ 
		if (getCondition().trim().equals(""))
			condition="1=1";
		else {
			condition="name like '%"+condition+"%' or code like '%"+condition+"%'";
		}
		java.util.List<String> fields=new java.util.ArrayList<String>();
		fields.add("id");
		fields.add("name");
		fields.add("code");
		fields.add("description");
		fields.add("status");
		fields.add("parent.name");
		
		java.util.List<String> alis=new java.util.ArrayList<String>();
		alis.add("id");
		alis.add("name");
		alis.add("code");
		alis.add("description");
		alis.add("status");
		alis.add("parent");
		String result=com.uscms.util.Search.ToObjectJson(service.find(condition), fields,alis,pageNumber,rowsCount);
		setData(result);
		return "success";
	}
	public String add()
	{ 	 
		service.setObject(actor);
		service.getObject().setId(com.uscms.util.Tool.CreateID());

		if (parentId!="")
		{  
			actor.getParent().setId(parentId);
		}

		/*
		 * 判断code是否存在
		 * */
		List<Object> lTemps=service.find("code='"+actor.getCode()+"'");
		if (lTemps!=null && lTemps.size()>0) 
		{
			setTips("角色代码重复！");
			return this.SUCCESS;
		}
		if (service.save()>0)
		{ 
			setTips("新增角色成功！"); 
			return this.SUCCESS;
		}
		else {
			setTips("角色新增失败！"); 
			return this.SUCCESS;
		}

	}
	 

	/*根据角色ID号进行删除，前提该角色没有子角色*/
	public String delActor()
	{   
		service.setObject(actor); 
		Object objTemp=service.getObject();//获取库中的对象
		if (objTemp==null) {
			setTips("系统没有获取到符合要求的角色，无法完成删除操作！");
			return this.SUCCESS;
		}//对象不存在
		service.setObject((com.uscms.bean.Actor)objTemp);
		Set<com.uscms.bean.Actor> lSons=((com.uscms.bean.Actor)service.getObject()).getChildren();
		if (lSons!=null && lSons.size()>0)
		{
			setTips("角色【"+service.getObject().getName()+"】存在子角色，不能删除！");
			return this.SUCCESS;
		}

		if (service.delete()>0)
		{
			setTips("角色【"+service.getObject().getName()+"】已经成功删除！");
			return this.SUCCESS;
		}
		else {
			setTips("角色【"+service.getObject().getName()+"】删除失败！");
			return this.SUCCESS;
		}

	}

	public String delActors()
	{   
		service.setObject(actor); 
		String ids=service.getObject().getId();//123123,123134
		ids=ids.replace(",", "' or id='");
		ids="id='"+ids+"'"; 

		List<Object> lObjs=service.find(ids);
		if (lObjs==null || lObjs.size()==0)
		{
			setTips("抱歉，系统没有查找到符合您删除角色！");
			return this.SUCCESS;
		} 
		int count=lObjs.size();
		if (service.deleteAll(lObjs)>0)
		{
			setTips("系统已经删除了【"+count+"】个角色！");
			return this.SUCCESS;
		}
		else {
			setTips("您选择的角色删除失败，原因是因为部分角色在使用中！");
			return this.SUCCESS;
		} 
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public int getRowsCount() {
		return rowsCount;
	}
	public void setRowsCount(int rowsCount) {
		this.rowsCount = rowsCount;
	}

}
