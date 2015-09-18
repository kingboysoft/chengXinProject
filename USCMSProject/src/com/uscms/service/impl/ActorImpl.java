package com.uscms.service.impl;
import java.util.Set; 
import com.uscms.bean.AbsObject;
import com.uscms.bean.CreditRecieptRecord;
import com.uscms.bean.StudentClass;
import com.uscms.bean.SystemMenu;
import com.uscms.service.IActor; 
public class ActorImpl extends ServiceImpl implements IActor {

	@Override
	public int setPower(Set<SystemMenu> powers) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int cancelPower(Set<SystemMenu> powers) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<SystemMenu> getPowers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<CreditRecieptRecord> getWaitCreditReciept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<StudentClass> getMyStudentClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
