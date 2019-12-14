package com.capgemini.springrest.medicalshop.exception;

public class OMSException extends Exception {

	private static final long serialVersionUID = 1L;

	public OMSException(String s) {
		System.err.println(s);
	}
}
