package com.tyss.alphaattendanceapp.exceptionclasses;

public class DuplicateEmailException extends RuntimeException{
	@Override
	public String getMessage() {
		return "The Email Is Allready Exist In Database";
	}
}
