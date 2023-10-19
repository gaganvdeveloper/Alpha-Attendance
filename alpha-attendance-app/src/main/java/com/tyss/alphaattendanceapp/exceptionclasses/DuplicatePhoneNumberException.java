package com.tyss.alphaattendanceapp.exceptionclasses;

public class DuplicatePhoneNumberException extends RuntimeException{
	@Override
	public String getMessage() {
		return "The Phone Number Is Already Exist In Database";
	}
}
