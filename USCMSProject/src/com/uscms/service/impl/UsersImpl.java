package com.uscms.service.impl;

import java.util.Set;

import com.uscms.bean.Actor;
import com.uscms.bean.SystemMenu;
import com.uscms.service.IUsers;

public class UsersImpl extends ServiceImpl implements IUsers {

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
	public int login() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int changePassword(String newPwd) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int setActors(Set<Actor> actors) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Actor> getActors() {
		// TODO Auto-generated method stub
		return null;
	}

}
