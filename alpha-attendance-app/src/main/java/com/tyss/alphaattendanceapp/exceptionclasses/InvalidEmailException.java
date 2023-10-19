package com.tyss.alphaattendanceapp.exceptionclasses;

public class InvalidEmailException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid Email, the Formate of Provided Email is Invalid...";
	}
	
}
