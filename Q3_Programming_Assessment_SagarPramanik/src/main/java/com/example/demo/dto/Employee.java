package com.example.demo.dto;

public class Employee {
private String name;
private Integer id;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
@Override
public String toString() {
	return "Employee [name=" + name + ", id=" + id + "]";
}
public Employee(String name, Integer id) {
	super();
	this.name = name;
	this.id = id;
}

}
