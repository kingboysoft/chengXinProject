package com.uscms.util;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Spring {
	/*************************************************
	 * @name:GetSpringObject
	 * @description:根据objId从Spring中获取对象
	 * @param objId:对象名称或ID
	 * @return 返回对象
	 *************************************************/
	public static Object GetSpringObject(String objID)
	{
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();  
		ApplicationContext ctx=WebApplicationContextUtils.getWebApplicationContext(application);
		return ctx.getBean(objID);
	}
	/*************************************************
	 * @name:GetObjectFromSpring
	 * @description:根据objId从Spring中获取对象,适用于Console或APP Project程序
	 * @param name:对象名称或ID
	 * @return 返回对象
	 *************************************************/
	public static Object GetObjectFromSpring(String name)
	{
		 ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		 return ctx.getBean(name); 
	}
}
