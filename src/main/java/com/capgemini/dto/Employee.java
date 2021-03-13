package com.capgemini.dto;

public class Employee {
	
	private int employeeId;
	private String name;
	private int exp;
	private int salary;
	private Project project;
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String name, int exp, int salary, Project project) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.exp = exp;
		this.salary = salary;
		this.project = project;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", exp=" + exp + ", salary=" + salary
				+ ", project=" + project.getProjectName() + "]";
	}
	
	

}