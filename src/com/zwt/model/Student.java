package com.zwt.model;

/*
 * 这是一个javaBean，
 * 对student表的映射
 */

public class Student {
	private String sno;  //学号
	private String sname; //姓名
	private String ssex; //性别
	private int age;   //年龄
	private int sclass; //班级
	private String grade; //年级
	private String dept; //系别
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSsex() {
		return ssex;
	}
	public void setSsex(String ssex) {
		this.ssex = ssex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getSclass() {
		return sclass;
	}
	public void setSclass(int sclass) {
		this.sclass = sclass;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
}
