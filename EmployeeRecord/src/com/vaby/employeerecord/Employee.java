package com.vaby.employeerecord;

public class Employee
{
	String name;
	double sal;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", sal=" + sal + "]";
	}
	public Employee(String name, double sal) {
		super();
		this.name = name;
		this.sal = sal;
	}
	public Employee() {
		super();
	}
	
	
}
