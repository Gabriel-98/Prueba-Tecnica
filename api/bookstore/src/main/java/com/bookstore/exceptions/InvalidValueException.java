package com.bookstore.exceptions;

public class InvalidValueException extends Exception {

	public InvalidValueException(String message){
        super(message);
	}

	public InvalidValueException(Throwable cause, String message){
        super(message, cause);
	}
}
