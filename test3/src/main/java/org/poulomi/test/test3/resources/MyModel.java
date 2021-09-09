package org.poulomi.test.test3.resources;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyModel {
	
String name;
String surName;
int age;


public MyModel() {
	
}	


public MyModel(String name, String surName, int age) {
	this.name = name;
	this.surName = surName;
	this.age = age;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSurName() {
	return surName;
}
public void setSurName(String surName) {
	this.surName = surName;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}


}
