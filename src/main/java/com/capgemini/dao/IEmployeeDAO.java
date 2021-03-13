package com.capgemini.dao;

import java.util.List;
import com.capgemini.dto.Project;

import com.capgemini.dto.Employee;
import com.capgemini.exceptions.InvalidEmployeeException;
import com.capgemini.exceptions.InvalidEmployeeException;
import com.capgemini.exceptions.WrongSalaryExceptions;

public interface IEmployeeDAO {
	
	 public boolean addEmployee(Employee e)throws WrongSalaryExceptions;
	 
	 public boolean editSalaryByEmployeeId(int id,int salary)throws InvalidEmployeeException;
	 
	 public boolean editExpByEmployeeId(int id,int exp)throws InvalidEmployeeException;
	 
	 public List<Employee> getAllEmployees();
	 
	 public List<Employee> getEmployeeBySalary(int salary);
	 
	 public List<Employee> getEmployessBySalaryRange(int salaryRangeMin,int salaryRangeMax);
	 
	 public List<Project> getAllProjects();

	 public int getCountinProject(String projectName);
	 
	 public List<Employee> getEmployeeinProject(String projectName);
	 
	 public List<Employee> getAllEmployeeinLocation(String location);
}