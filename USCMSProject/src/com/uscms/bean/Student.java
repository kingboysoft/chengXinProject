package com.uscms.bean;

public class Student extends AbsHuman {
	private StudentClass myClass=null;//班级

	public StudentClass getMyClass() {
		return myClass;
	}

	public void setMyClass(StudentClass myClass) {
		this.myClass = myClass;
	}
}
