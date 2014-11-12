package com.vaby.customadapterdemo;

public class Person
{
	String Name;
	int age;
		
	public Person()
	{
		super();
	}

	
	@Override
	public String toString()
	{
		return "Person [Name=" + Name + ", age=" + age + "]";
	}


	public Person(String name, int age)
	{
		super();
		Name = name;
		this.age = age;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
