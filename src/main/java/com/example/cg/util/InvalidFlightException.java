package com.example.cg.util;

public class InvalidFlightException extends Exception {

	public InvalidFlightException() {
		super("No such Flight Available");
	}

	public InvalidFlightException(String message) {
		super(message);
	}

}
