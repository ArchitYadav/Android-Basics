package com.example.sqlitedemo1.model;

public class Employee 
{
	int eid;
	String name;
	double salary;
	int deptId;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public Employee(int eid, String name, double salary, int deptId) {
		super();
		this.eid = eid;
		this.name = name;
		this.salary = salary;
		this.deptId = deptId;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "eid=" + eid + ", name=" + name + ", salary=" + salary
				+ ", deptId=" + deptId;
	}
	
	
	
}
