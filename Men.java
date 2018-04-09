package com.practice.example;

public class Men implements Comparable<Men>{
	private int age;
	private String name;
	
	public Men(int age,String name){
		this.age = age;
		this.name = name;
	}
	
	public int compareTo(Men arg0) {
		// TODO Auto-generated method stub
		if(this.age >  arg0.getAge())
			return 1;
		else if(this.age == arg0.getAge())
			return 0;
		else
			return 0;
		
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Men [age=" + age + ", name=" + name + "]";
	}

	

}
