package com.uscms.service;

import java.util.Set;

import com.uscms.bean.CreditReciept;

public interface IApprovedQueue extends IService {
	/**********************************************
	 * @name:获取当前用户审批诚信票据
	 * @description:获取当前用户所有的审批票据
	 * @param： condition查询条件
	 * @return:如果存在，返回已经审批的票据，否则返回空
	 **********************************************/
	public Set<CreditReciept> getCheckedCreditReciepts(String condition);
}
