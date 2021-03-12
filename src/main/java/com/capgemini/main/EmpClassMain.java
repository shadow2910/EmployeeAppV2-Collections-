package com.capgemini.main;



import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.db.EmployeeDB;
import com.capgemini.dto.Employee;
import com.capgemini.services.EmployeeServiceImplementation;
import com.capgemini.services.IEmployeeService;

public class EmpClassMain {
	
	IEmployeeService empService = new EmployeeServiceImplementation();
	
	public static void main(String[] args) {
		
		EmpClassMain app = new EmpClassMain();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println(" === MENU ==== ");
			System.out.println("1. add employee ");
			System.out.println("2. Display All Employee ");
			System.out.println("3. Edit salary and experience using Eid");
			System.out.println("4. Display employee based on salary");
			System.out.println("5. Display employee based on salary range");
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
				
				Employee e = new Employee(empId, name, empExp, empSalary);
				
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
					System.out.println(" ========================================================");
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
				List<Employee> emps1=app.empService.getEmployeeBySalary(empsal);
				Iterator<Employee> itr1=emps1.iterator();
				while(itr1.hasNext()) {
					Employee emp=itr1.next();
					System.out.println(emp);
				}
				break;
			case 5:
				System.out.println("Enter lower limit of salary");
				int empSalLow=Integer.parseInt(sc.nextLine());
				System.out.println("Enter upper limit of salary");
				int empSalHigh=Integer.parseInt(sc.nextLine());
				List<Employee> emps2=app.empService.getEmployessBySalaryRange(empSalLow,empSalHigh);
				Iterator<Employee> itr2=emps2.iterator();
				while(itr2.hasNext()) {
					Employee emp=itr2.next();
					System.out.println(emp);
				}
				break;
			case 0:
				System.exit(0);
			
			
			
			}//end switch
		}// end while
		
		

	}//end main

}//end class