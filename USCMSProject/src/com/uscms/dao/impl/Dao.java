package com.uscms.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List; 
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.sun.istack.internal.FinalArrayList;
import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
public class Dao implements com.uscms.dao.IDal {

	private HibernateTemplate ht=null; 

	private HibernateTemplate getHibernateTemplate()
	{
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		if (ht==null)
			ht=(HibernateTemplate)ctx.getBean("hibernateTemplate");
		return ht;
	}
	@Override
	public int save(Object obj) {
		try { 
			String result=getHibernateTemplate().save(obj).toString();
			 
			if (result.equals(((com.uscms.bean.AbsObject)obj).getId())) 
			  return 1;
			else {
				return 0;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return -100;
		}
	}

	@Override
	public int saveAll(final List<Object> objs) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				for (int i = 0; i < objs.size(); i++) {
					session.save(objs.get(i));
					if (i % 20 == 0) {
						session.flush();
						session.clear();
					}
				} 
				return 1;
			}
		}); 
	}

	@Override
	public int delete(Object obj) {
		getHibernateTemplate().delete(obj);
		return 1;
	}

	@Override
	public int deleteAll(final List<Object> objs) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session){
				try {
					for (int i = 0; i < objs.size(); i++) {
						session.delete(objs.get(i));
						if (i % 20 == 0) {
							session.flush();
							session.clear();
						}
					} 
					return 1;
				} catch (Exception e) {
					e.printStackTrace();
					return -1;
				}
				
			}
		});
	}

	@Override
	public int update(Object obj) {
		getHibernateTemplate().update(obj);
		return 1;
	}

	@Override
	public int updateAll(final List<Object> objs) {
		return this.getHibernateTemplate().execute(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				for (int i = 0; i < objs.size(); i++) {
					session.update(objs.get(i));
					if (i % 20 == 0) {
						session.flush();
						session.clear();
					}
				} 
				return 1;
			}
		});
	}

	@Override
	public Object get(Class<com.uscms.bean.AbsObject> entityClass, Serializable id) {
		return getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<Object> find(Object obj, String queryString) {
		try {
			return getHibernateTemplate().find("from "+obj.getClass().getName()+" where "+queryString);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} 
	}

	@Override
	public List<Object> findByName(Object obj, String queryName) {
		return getHibernateTemplate().find("from "+obj.getClass().getName()+" where name like '%"+queryName+"%'");
	}

	@Override
	public List<Object> findByPage(final Object obj,final String con, final int offset,
			final int length) {
		List list = getHibernateTemplate().executeFind(new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Query query = session.createQuery("from "+obj.getClass().getName()+" where "+con);
				query.setFirstResult(offset);
				query.setMaxResults(length);
				List list = query.list();
				return list;
			}
		});
		return list;
	}

	@Override
	public List<Object> findBySelf(String sqlStatement) {
		List list=getHibernateTemplate().find(sqlStatement);
		 
		return list;
	}

}
