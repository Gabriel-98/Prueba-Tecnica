package com.bookstore.exceptions;

public class ObjectNotFoundException extends Exception {

	public ObjectNotFoundException(String message){
		super(message);
	}

	public ObjectNotFoundException(Throwable cause, String message){
        super(message, cause);
	}
}
