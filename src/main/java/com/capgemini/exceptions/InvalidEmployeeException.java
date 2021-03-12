package com.capgemini.exceptions;


public class InvalidEmployeeException extends Exception {

	int empID;
	public InvalidEmployeeException(int empID) {
		super();
		this.empID=empID;
	}
	@Override
	public String toString() {
		return "InvalidEmployeeId [empID=" + empID + "]";
	}
	
}