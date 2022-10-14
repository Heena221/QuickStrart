package com.example.demo.services;

import java.io.PrintWriter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//unchecked Exception=>can handle or Declare,can leave it without handle or declare

@SuppressWarnings("serial")
@AllArgsConstructor
@Setter
@Getter

public class ElementNotFoundException extends RuntimeException {
	
	
	String errorCode;
	String message;
	@Override
	public void printStackTrace(PrintWriter s) {

		s.write(this.errorCode+","+this.message);
	}
	
	
//	public ElementNotFoundException(String string, String string2) {
//		
//	}
	//checked Exception you have either handle or declare, not doing it will be an exception

}
