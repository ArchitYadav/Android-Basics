package com.example.sqlitedemo1.model;

public class Department
{
	int deptId;
	String name;
	
	public Department() 
	{
		super();
	}
	
	public Department(int deptId, String name)
	{
		super();
		this.deptId = deptId;
		this.name = name;
	}
	
	public int getDeptId()
	{
		return deptId;
	}
	
	public void setDeptId(int deptId)
	{
		this.deptId = deptId;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	@Override
	public String toString() 
	{
		return " Dept Name=" + name;
	}
	
	
	
}
