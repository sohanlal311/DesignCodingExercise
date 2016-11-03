package com.rajendar.employee;

/**
 * 
 * @author rku105
 * 
 *         This class will be used to store the employee information.
 */
public class Employee {
	private String id;
	private String name;
	private int age;
	private double salary;
	private String mgrId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getMgrId() {
		return mgrId;
	}

	public void setMgrId(String mgrId) {
		this.mgrId = mgrId;
	}

	public String toString() {
		return String.format("%-4s %-15s %4s %10s  %-4s", id, name, age,
				salary, mgrId);
	}
}
