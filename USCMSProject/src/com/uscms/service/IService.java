package com.uscms.service;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.uscms.bean.AbsObject;

public interface IService {
	public int save();
	public int saveAll(List<Object> objs);	
	public int delete();
	public int deleteAll(List<Object> objs);
	public int update();
	public int updateAll(List<Object> objs);
	public Object get(Class entityClass,Serializable id);
	public List<Object> find(String queryString);
	public List<Object> findByName(String queryName);
	public List<Object> findByPage(String con,final int offset,
			final int length);
	public List<Object> findBySelf(String sqlStatement);
	
	public void loadout();
	public int loadin(Set<AbsObject> data);
	public void print();
}
