package com.capgemini.main;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.db.EmployeeDB;
import com.capgemini.dto.Employee;
import com.capgemini.services.EmployeeServiceImplementation;
import com.capgemini.services.IEmployeeService;
import com.capgemini.dto.Project;
public class EmpClassMain {
	
	IEmployeeService empService = new EmployeeServiceImplementation();
	
	public static void main(String[] args) {
		
		EmpClassMain app = new EmpClassMain();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println(" === MENU ==== ");
			System.out.println("1. Add Employee ");
			System.out.println("2. Display All Employee ");
			System.out.println("3. Edit salary and experience using Eid");
			System.out.println("4. Display employee based on salary");
			System.out.println("5. Display employee based on salary range");
			System.out.println("6. Display all active projects");
			System.out.println("7. Count the number of employees in a project");
		    System.out.println("8. Details of employees in a project");
		    System.out.println("9. Details of employees working in a particular location");
			System.out.println("0. EXIT");
			System.out.println("Enter Option");
			int option = Integer.parseInt(sc.nextLine());
			switch(option)
			{
			
			case 1:
				
				System.out.println("Enter Employee Id ");
				int empId = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Salary ");
				int empSalary = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Exp ");
				int empExp = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Name ");
				String name = sc.nextLine();
				
				System.out.println("Enter Project Name");
				String projectName=sc.nextLine();
				
				System.out.println("Enter Location");
				String location=sc.nextLine();
				
				System.out.println("Enter Project Head");
				String projectHead=sc.nextLine();
				
				System.out.println("Enter Project start year");
				int startYear=Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Project end year");
				int endYear=Integer.parseInt(sc.nextLine());
				
				Project project=new Project(projectName,location,projectHead,startYear,endYear);
				Employee e = new Employee(empId, name, empExp, empSalary,project);
				
				try
				{
					boolean isInserted = app.empService.addEmployee(e);
					if(isInserted)
					{
						System.out.println(" Employee Added !!!");
					}
					else
					{
						 throw new Exception("Cannot added Employee ...");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" Contact to Customer Care ... "+ex); // raise the exception
				}
				
				break;
			case 2:
				
				List<Employee> emps = app.empService.getAllEmployees();
				Iterator<Employee> itr=emps.iterator();
				while(itr.hasNext()) {
					Employee emp=itr.next();
					System.out.println(emp);
					System.out.println(" ===============================================================================");
				}
				break;
			case 3:
				System.out.println("Enter employee id");
				int empID=Integer.parseInt(sc.nextLine());
				System.out.println("Enter experience");
				int empEXp=Integer.parseInt(sc.nextLine());
				System.out.println("Enter salary");
				int empsalary=Integer.parseInt(sc.nextLine());
				
				try {
				if(app.empService.editExpByEmployeeId(empID,empEXp))
					System.out.println("Experience change successfull");
				else {
					System.out.println("Cannot change experience");
				}
				if(app.empService.editSalaryByEmployeeId(empID,empsalary,empEXp))
					System.out.println("Salary change successfull");
				else {
					System.out.println("Cannot change salary");
				}
				}
				catch(Exception ex) {
					System.out.println(ex);
				}
				break;
			case 4:
				System.out.println("Enter salary");
				int empsal=Integer.parseInt(sc.nextLine());
				try {
					List<Employee> emps1=app.empService.getEmployeeBySalary(empsal);
					Iterator<Employee> itr1=emps1.iterator();
					while(itr1.hasNext()) {
						Employee emp=itr1.next();
						System.out.println(emp);
					}
				}
				catch(Exception e1) {
					System.out.println(e1);
				}
				break;
			case 5:
				System.out.println("Enter lower limit of salary");
				int empSalLow=Integer.parseInt(sc.nextLine());
				System.out.println("Enter upper limit of salary");
				int empSalHigh=Integer.parseInt(sc.nextLine());
				try {
					List<Employee> emps2=app.empService.getEmployessBySalaryRange(empSalLow,empSalHigh);
					Iterator<Employee> itr2=emps2.iterator();
					while(itr2.hasNext()) {
						Employee emp=itr2.next();
						System.out.println(emp);
					}
				}
				catch(Exception e2) {
					System.out.println(e2);
				}
				break;
			case 6:
				List<Project> projects=app.empService.getAllProjects();
				Iterator<Project> itr3=projects.iterator();
				while(itr3.hasNext()) {
					System.out.println(itr3.next());
				}
				break;
			case 7:
				System.out.println("Enter project name");
				String projectName1=sc.nextLine();
				try {
					int count=app.empService.getCountinProject(projectName1);
					System.out.println("No of employees in project "+projectName1+" :"+count);
				}
				catch(Exception e3) {
					System.out.println(e3);
				}
				break;
			case 8:
				System.out.println("Enter project name");
				String projectName2=sc.nextLine();
				List<Employee> emps3=new ArrayList<Employee>();
				try {
					emps3=app.empService.getEmployeeinProject(projectName2);
					Iterator<Employee> itr4=emps3.iterator();
					while(itr4.hasNext()) {
						System.out.println(itr4.next());
					}
				}
				catch(Exception e4) {
					System.out.println(e4);
				}
				break;
			case 9:
				System.out.println("Enter location");
				String location1=sc.nextLine();
				List<Employee> emps4=new ArrayList<Employee>();
				try {
					emps4=app.empService.getAllEmployeeinLocation(location1);
					Iterator<Employee> itr5=emps4.iterator();
					while(itr5.hasNext()) {
						System.out.println(itr5.next());
					}
				}catch(Exception e5) {
					System.out.println(e5);
				}
				
				break;
			case 0:
				System.exit(0);
			
			
			
			}//end switch
		}// end while
		
		

	}//end main

}//end class