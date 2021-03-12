package com.capgemini.exceptions;

public class WrongSalaryExceptions extends Exception{

	int salary;
	public WrongSalaryExceptions(int salary)
	{
		super();
		this.salary=salary;
	}
	@Override
	public String toString() {
		return "WrongExpSalary [salary=" + salary + "]";
	}
	
	
}
