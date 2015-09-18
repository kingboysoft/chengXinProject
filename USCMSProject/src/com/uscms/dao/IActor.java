package com.uscms.dao;

import java.util.Set; 

import com.uscms.bean.AbsObject;
public interface IActor extends IDal {
	public int setPower(AbsObject actor,Set<AbsObject> powers);//授权
	public int cancelPower(AbsObject actor,Set<AbsObject> powers);//取消指定集合权限
	public Set<AbsObject> getPowers(AbsObject actor);//获取角色权限�?
}
