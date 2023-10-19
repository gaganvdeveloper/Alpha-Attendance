package com.tyss.alphaattendanceapp.exceptionclasses;

public class IdNotFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "The Id Not Found, For the Entity Id Not Found";
	}
}
