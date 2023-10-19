package com.tyss.alphaattendanceapp.exceptionclasses;

public class InvalidPhoneNumberException extends RuntimeException{
	@Override
	public String getMessage() {
		return "Invalid Phone Number, The Phone Number Formate is Invalid";
	}
}
