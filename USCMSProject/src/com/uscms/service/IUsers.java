package com.uscms.service;

import java.util.Set;

import com.sun.jndi.url.corbaname.corbanameURLContextFactory;
import com.uscms.bean.SystemMenu;

public interface IUsers extends IService {
	/**********************************************
	 * @name:用户系统授权
	 * @description:将powers系统权限分配给当前用户
	 * @param： powers系统权限
	 * @return:大于0表示授权成功，其他表示授权失败
	 **********************************************/
	public int setPower(Set<SystemMenu> powers);
	/**********************************************
	 * @name:用户系统权限取消
	 * @description:将powers系统权限从当前用户中取消
	 * @param： powers系统权限
	 * @return:大于0表示取消成功，其他表示取消失败
	 **********************************************/
	public int cancelPower(Set<SystemMenu> powers);
	/**********************************************
	 * @name:获取当前用户所有权限
	 * @description:获取当前用户所有权限，该权限包括当前子用户权限
	 * @return:如果存在权限，则返回系统权限，否则返回空
	 **********************************************/
	public Set<SystemMenu> getPowers();
	/**********************************************
	 * @name:用户登录
	 * @description:根据当前用户的账号和密码，进行用户登录
	 * @return:如果验证通过，返回1，账号错误返回0，密码错误，返回-1，账户锁定，返回-2
	 **********************************************/
	public int login();
	/**********************************************
	 * @name:密码修改
	 * @description:根据提供的新密码，对当前用户密码进行修改
	 * @return:如果修改成功，返回1，否则返回0
	 **********************************************/
	public int changePassword(String newPwd);
	/**********************************************
	 * @name:设置当前用户角色
	 * @description:将参数集合中的角色分配给当前用户
	 * @param:actors设置的角色
	 * @return:如果操作成功，返回1，否则表示失败
	 **********************************************/
	public int setActors(Set<com.uscms.bean.Actor> actors);
	/**********************************************
	 * @name:获取用户角色
	 * @description:获取当前用户分配的角色
	 * @return:如果存在，返回角色，否则返回空
	 **********************************************/
	public Set<com.uscms.bean.Actor> getActors();
	
}
