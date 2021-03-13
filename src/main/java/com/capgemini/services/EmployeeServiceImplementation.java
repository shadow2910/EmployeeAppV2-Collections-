package com.capgemini.services;

import java.util.List;

import com.capgemini.dao.EmployeeDAOImplementation;
import com.capgemini.dao.IEmployeeDAO;
import com.capgemini.db.EmployeeDB;
import com.capgemini.dto.Employee;
import com.capgemini.exceptions.InvalidEmployeeException;
import com.capgemini.exceptions.WrongSalaryExceptions;
import com.capgemini.dto.Project;
import com.capgemini.exceptions.NotFoundException;
public class EmployeeServiceImplementation implements IEmployeeService {
	IEmployeeDAO dao;

	public EmployeeServiceImplementation() {
		dao = new EmployeeDAOImplementation();
	}

	public boolean addEmployee(Employee e) throws WrongSalaryExceptions {
		if (e.getSalary() > 50000) {
			throw new WrongSalaryExceptions(e.getSalary());
		} 
		else if(e.getSalary()>10000 && e.getExp()<3)
			throw new WrongSalaryExceptions(e.getSalary());
		else
			return dao.addEmployee(e);
	}
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}
	// ================================================================================
	public boolean editSalaryByEmployeeId(int id, int salary,int experience) throws InvalidEmployeeException,WrongSalaryExceptions {
		if(salary>50000) {
			throw new WrongSalaryExceptions(salary);
		}
		else if(salary>10000 && experience<3) {
			throw new WrongSalaryExceptions(salary);
		}
		else {	
		if (dao.editSalaryByEmployeeId(id, salary))
			return true;
		else
			throw new InvalidEmployeeException(id);
		}
	}

	public boolean editExpByEmployeeId(int id, int exp) throws InvalidEmployeeException {
		if (dao.editExpByEmployeeId(id, exp))
			return true;
		else
			throw new InvalidEmployeeException(id);
	}

	public List<Employee> getEmployeeBySalary(int salary) throws NotFoundException {
		List<Employee> emps = dao.getEmployeeBySalary(salary);
		if(emps.isEmpty())
			throw new NotFoundException();
		else
			return emps;
	}

	public List<Employee> getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) throws NotFoundException{
		List<Employee> emps = dao.getEmployessBySalaryRange(salaryRangeMin, salaryRangeMax);
		if(emps.isEmpty())
			throw new NotFoundException();
		else
			return emps;
	}
	
	public List<Project> getAllProjects(){
		return dao.getAllProjects();
	}

	public int getCountinProject(String projectName) throws NotFoundException{
		int count=0;
		count=dao.getCountinProject(projectName);
		if(count==0)
			throw new NotFoundException();
		else
			return count;
	}
	
	public List<Employee> getEmployeeinProject(String projectName) throws NotFoundException{
		List<Employee> emps=dao.getEmployeeinProject(projectName);
		if(emps.isEmpty())
			throw new NotFoundException();
		else
			return emps;
	}
	
	public List<Employee> getAllEmployeeinLocation(String location) throws NotFoundException{
		List<Employee> emps=dao.getAllEmployeeinLocation(location);
		if(emps.isEmpty())
			throw new NotFoundException();
		else
			return emps;
	}	
}