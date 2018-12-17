package edu.tecso.crud.exception;

public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = -6381480178329210280L;

	public BusinessException(String message) {
		super(message);
	}
	
}
