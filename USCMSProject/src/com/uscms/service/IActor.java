package com.uscms.service;

import java.util.Set;

import com.uscms.bean.AbsObject;
import com.uscms.bean.CreditRecieptRecord;
import com.uscms.bean.StudentClass;
import com.uscms.bean.SystemMenu;
 

public interface IActor extends IService {
  /**********************************************
   * @name:角色系统授权
   * @description:将powers系统权限分配给当前角色
   * @param： powers系统权限
   * @return:大于0表示授权成功，其他表示授权失败
   **********************************************/
  public int setPower(Set<SystemMenu> powers);
  /**********************************************
   * @name:角色系统权限取消
   * @description:将powers系统权限从当前角色中取消
   * @param： powers系统权限
   * @return:大于0表示取消成功，其他表示取消失败
   **********************************************/
  public int cancelPower(Set<SystemMenu> powers);
  /**********************************************
   * @name:获取当前角色所有权限
   * @description:获取当前角色所有权限，该权限包括当前子角色权限
   * @return:如果存在权限，则返回系统权限，否则返回空
   **********************************************/
  public Set<SystemMenu> getPowers();
  /**********************************************
   * @name:获取等待审批诚信单据
   * @description:获取当前角色待审批的诚信票据
   * @return:如果存在，则返回待审批票据，否则返回空
   **********************************************/
  public Set<CreditRecieptRecord> getWaitCreditReciept();
  /**********************************************
   * @name:获取当前角色拥有的班级权限
   * @description:获取当前角色所有的班级操作权限
   * @return:如果存在，则返回班级集合，否则返回空
   **********************************************/
  public Set<StudentClass> getMyStudentClasses();
}
