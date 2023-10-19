package com.tyss.alphaattendanceapp.exceptionclasses;

public class NoUserFoundException extends RuntimeException{
	@Override
	public String getMessage() {
		return "No Users Are Present In Database, Database Is Empty...";
	}
}
