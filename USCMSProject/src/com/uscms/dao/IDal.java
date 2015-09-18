package com.uscms.dao;

import java.io.Serializable;
import java.util.List;

import com.uscms.bean.AbsObject;
/*
 * 数据库访问操作公共方�?
 */
public interface IDal {
	public int save(Object obj);
	public int saveAll(List<Object> objs);	
	public int delete(Object obj);
	public int deleteAll(List<Object> objs);
	public int update(Object obj);
	public int updateAll(List<Object> objs);
	public Object get(Class<AbsObject> entityClass,Serializable id);
	public List<Object> find(Object obj,String queryString);
	public List<Object> findByName(Object obj,String queryName);
	public List<Object> findByPage(Object obj,String con,final int offset,
			final int length);
	public List<Object> findBySelf(String sqlStatement);

}
