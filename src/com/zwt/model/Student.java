package com.zwt.model;

/*
 * ����һ��javaBean��
 * ��student���ӳ��
 */

public class Student {
	private String sno;  //ѧ��
	private String sname; //����
	private String ssex; //�Ա�
	private int age;   //����
	private int sclass; //�༶
	private String grade; //�꼶
	private String dept; //ϵ��
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
