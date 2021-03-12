package com.capgemini.services;

import java.util.List;

import com.capgemini.dto.Employee;
import com.capgemini.exceptions.InvalidEmployeeException;
import com.capgemini.exceptions.WrongSalaryExceptions;

public interface IEmployeeService {
	
	public boolean addEmployee(Employee e)throws WrongSalaryExceptions;
	 
	 public boolean editSalaryByEmployeeId(int id,int salary,int experience)throws InvalidEmployeeException,WrongSalaryExceptions;
	 
	 public boolean editExpByEmployeeId(int id,int exp)throws InvalidEmployeeException;
	 
	 public List<Employee> getAllEmployees();
	 
	 public List<Employee> getEmployeeBySalary(int salary);
	 
	 public List<Employee> getEmployessBySalaryRange(int salaryRangeMin,int salaryRangeMax);

}