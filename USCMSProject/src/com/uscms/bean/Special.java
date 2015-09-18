package com.uscms.bean;
/******************************************
 *类名：专业类
 *功能描述：描述专业的属性及功能
 *作者:熊凯
 *时间：2015-9-9
 ********************************************/
public class Special extends AbsObject {
	private String code = ""; // 专业代码
	private String target = ""; // 专业培养目标
	private String lessons = ""; // 主要课程
	private Integer count = 0; // 就读人数
	private Integer years = 0;// 开设年度
	private Integer lessonCount = 0;// 总课时数
	private Integer practiceCount = 0;// 实践课时数
	private Integer theoryCount = 0;// 理论课时数
	private Float score = 0f;// 总学分
	private String studyYears = "四年制"; // 学制
	private String enterQuality = "";// 入学条件
	private Organization department = null; // 开设院系
	private String memo = ""; // 备注
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getLessons() {
		return lessons;
	}
	public void setLessons(String lessons) {
		this.lessons = lessons;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Integer getYears() {
		return years;
	}
	public void setYears(Integer years) {
		this.years = years;
	}
	public Integer getLessonCount() {
		return lessonCount;
	}
	public void setLessonCount(Integer lessonCount) {
		this.lessonCount = lessonCount;
	}
	public Integer getPracticeCount() {
		return practiceCount;
	}
	public void setPracticeCount(Integer practiceCount) {
		this.practiceCount = practiceCount;
	}
	public Integer getTheoryCount() {
		return theoryCount;
	}
	public void setTheoryCount(Integer theoryCount) {
		this.theoryCount = theoryCount;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public String getStudyYears() {
		return studyYears;
	}
	public void setStudyYears(String studyYears) {
		this.studyYears = studyYears;
	}
	public String getEnterQuality() {
		return enterQuality;
	}
	public void setEnterQuality(String enterQuality) {
		this.enterQuality = enterQuality;
	}
	public Organization getDepartment() {
		return department;
	}
	public void setDepartment(Organization department) {
		this.department = department;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
}
