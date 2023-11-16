package com.bookstore.exceptions;

public class MandatoryFieldException extends Exception {
    private String fieldName;

	public MandatoryFieldException(String fieldName){
		super("El campo " + fieldName + " es obligatorio");
		this.fieldName = fieldName;
	}

	public MandatoryFieldException(Throwable cause, String fieldName){
        super("El campo " + fieldName + " es obligatorio", cause);
		this.fieldName = fieldName;
	}

	// Retorna el nombre del campo.
	public String getFieldName(){
		return fieldName;
	}
}
