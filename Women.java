package com.practice.example;

public class Women implements Comparable<Women>{
	private int age;
	private String name;
	private boolean engaged;
	private Men current;
	public Men getCurrent() {
		return current;
	}
	public void setCurrent(Men current) {
		this.current = current;
	}
	public Women(int age,String name){
		this.age = age;
		this.name = name;
		this.engaged = false;
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
	public int compareTo(Women arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean isEngaged() {
		return engaged;
	}
	public void setEngaged(boolean engaged) {
		this.engaged = engaged;
	}
	@Override
	public String toString() {
		return "Women [age=" + age + ", name=" + name + "]";
	}
	
}
