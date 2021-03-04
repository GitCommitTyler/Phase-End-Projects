package org.example.Exceptions;

public class InvalidFileNameException extends RuntimeException {
	public InvalidFileNameException(String name){
		super("Name " + name +" is not valid");
	}
}
