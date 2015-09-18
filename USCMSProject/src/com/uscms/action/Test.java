package com.uscms.action;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test {
  public static void main(String[] args)
  {
	  ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
	  com.uscms.service.impl.CreditTypeImpl menuImpl=(com.uscms.service.impl.CreditTypeImpl)ctx.getBean("credittype");
	   
      List<Object> objs=menuImpl.find("1=1");
      for(Object obj:objs)
      {
    	  com.uscms.bean.CreditType a=(com.uscms.bean.CreditType)obj;
    	  System.out.println(a.getName());
      } 
  }
}
