package com.rays.test;

public class Employee {

	private String empName;
	private String company;
	private int salary;
	
	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee() {
		
	}
	
	public Employee(String empName,String company,int salary ) {
		this.empName = empName;
		this.company = company;
		this.salary = salary;
	}
	
}
