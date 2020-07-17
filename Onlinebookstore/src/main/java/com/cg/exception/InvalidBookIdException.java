package com.cg.exception;

@SuppressWarnings("serial")
public class InvalidBookIdException extends Exception{
	public InvalidBookIdException(String error_Msg) {
		super(error_Msg);
	}
}