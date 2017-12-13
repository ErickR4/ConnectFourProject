package com.company;
public abstract class Person {						//16) Abstraction
	private String name;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
}