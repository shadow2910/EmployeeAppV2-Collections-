package com.capgemini.db;


import java.util.HashMap;
import java.util.Map;
import java.util.*;

import com.capgemini.dto.Employee;

public class EmployeeDB {
	// Employee cannot be resolved to a type
	public static HashMap <Integer, Employee> employees=new HashMap<Integer, Employee>();
	public  boolean addEmployee(Employee e)
	{
		EmployeeDB.employees.put(e.getEmployeeId(), e);
		return true;
	}
	
	public EmployeeDB() {
		super();
		Employee e1=new Employee(101,"Ramesh",5,25000);
		Employee e2=new Employee(102,"Suresh",2,8000);
		Employee e3=new Employee(103,"Rakesh",7,40000);
		Employee e4=new Employee(104,"Lokesh",0,5000);
		
		EmployeeDB.employees.put(e1.getEmployeeId(), e1);
		EmployeeDB.employees.put(e2.getEmployeeId(), e2);
		EmployeeDB.employees.put(e3.getEmployeeId(), e3);
		EmployeeDB.employees.put(e4.getEmployeeId(), e4);
		// TODO Auto-generated constructor stub
	}

	public static int getCount()
	{	
		return EmployeeDB.employees.size();
	}
}