package com.uscms.service.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.uscms.bean.AbsObject;
import com.uscms.dao.IDal;


public class ServiceImpl implements com.uscms.service.IService {
	private AbsObject object=null;
	private IDal dal;
	public AbsObject getObject() {
		return object;
	}

	public void setObject(AbsObject object) {
		this.object = object;
	}

	public IDal getDal() {
		return dal;
	}

	public void setDal(IDal dal) {
		this.dal = dal;
	}

	@Override
	public int save() {
		// TODO Auto-generated method stub
		return dal.save(object);
	}

	@Override
	public int saveAll(List<Object> objs) {
		// TODO Auto-generated method stub
		return dal.saveAll(objs);
	}

	@Override
	public int delete() {
		// TODO Auto-generated method stub
		return dal.delete(object);
	}

	@Override
	public int deleteAll(List<Object> objs) {
		// TODO Auto-generated method stub
		return dal.deleteAll(objs);
	}

	@Override
	public int update() {
		// TODO Auto-generated method stub
		return dal.update(object);
	}

	@Override
	public int updateAll(List<Object> objs) {
		// TODO Auto-generated method stub
		return dal.updateAll(objs);
	}

	@Override
	public Object get(Class entityClass, Serializable id) {
		// TODO Auto-generated method stub
		return dal.get(entityClass, id);
	}

	@Override
	public List<Object> find(String queryString) {
		// TODO Auto-generated method stub
		return dal.find(object, queryString);
	}

	@Override
	public List<Object> findByName(String queryName) {
		// TODO Auto-generated method stub
		return dal.findByName(object, queryName);
	}

	@Override
	public List<Object> findByPage(String con, int offset, int length) {
		// TODO Auto-generated method stub
		return dal.findByPage(object, con, offset, length);
	}

	@Override
	public List<Object> findBySelf(String sqlStatement) {
		// TODO Auto-generated method stub
		return dal.findBySelf(sqlStatement);
	}

	@Override
	public void loadout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int loadin(Set<AbsObject> data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
