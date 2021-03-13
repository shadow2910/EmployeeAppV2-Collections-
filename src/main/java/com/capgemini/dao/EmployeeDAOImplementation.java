package com.capgemini.dao;


import java.util.ArrayList;
import java.util.List;

import com.capgemini.db.EmployeeDB;
import com.capgemini.dto.Employee;
import com.capgemini.exceptions.InvalidEmployeeException;
import com.capgemini.exceptions.WrongSalaryExceptions;
import com.capgemini.dto.Project;
public class EmployeeDAOImplementation implements IEmployeeDAO {
	EmployeeDB db=new EmployeeDB();
	Employee emp=new Employee();

	public boolean addEmployee(Employee e) throws WrongSalaryExceptions{
		return db.addEmployee(e);
	}

	public List<Employee> getAllEmployees() {
		List<Employee> emps=new ArrayList<Employee>();
		for (Employee emp:EmployeeDB.employees.values()) {
			emps.add(emp);
		}
		return emps;
	}
	//============================================================
	
	
	public boolean editSalaryByEmployeeId(int id,int salary) throws InvalidEmployeeException {
		Employee emp=EmployeeDB.employees.get(id);
		if(emp==null)
			return false;
		else {
			emp.setSalary(salary);
			return true;
		}
			
	}

	public boolean editExpByEmployeeId(int id,int exp) throws InvalidEmployeeException {
		
		Employee emp=EmployeeDB.employees.get(id);
		if(emp==null)
			return false;
		else {
			emp.setExp(exp);
			return true;
			}	
	}
	public List<Employee> getEmployeeBySalary(int salary) {
		List<Employee> emps=new ArrayList<Employee>();
		for (Employee emp:EmployeeDB.employees.values())  {
			if(emp.getSalary()==salary) {
				emps.add(emp);
			}
		}
		return emps;
	}

	public List<Employee> getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		List<Employee> emps=new ArrayList<Employee>();
		for (Employee emp:EmployeeDB.employees.values()) {
			if(emp.getSalary()<=salaryRangeMax && emp.getSalary() >= salaryRangeMin)
					emps.add(emp);
		}
		return emps;
	}
	
	public List<Project> getAllProjects(){
		List<Project> projects=new ArrayList<Project>();
		for(Employee emp:EmployeeDB.employees.values()) {
			Project p=emp.getProject();
			if(!projects.contains(p)) {
				projects.add(p);
			}
		}
	return projects;
	}
	public int getCountinProject(String projectName) {
		int count=0;
		for(Employee emp:EmployeeDB.employees.values()) {
			if(emp.getProject().getProjectName().equals(projectName))
				count++;
		}
		return count;
	}
	
	public List<Employee> getEmployeeinProject(String projectName){
		List<Employee> emps=new ArrayList<Employee>();
		for (Employee emp : EmployeeDB.employees.values()) {
			if(emp.getProject().getProjectName().equals(projectName))
				emps.add(emp);
		}
		return emps;
	}
	
	public List<Employee> getAllEmployeeinLocation(String location){
		List<Employee> emps=new ArrayList<Employee>();
		for (Employee emp : EmployeeDB.employees.values()) {
			if(emp.getProject().getLocation().equals(location))
				emps.add(emp);
		}
		return emps;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}