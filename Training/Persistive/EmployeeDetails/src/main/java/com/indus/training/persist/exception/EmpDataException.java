package com.indus.training.persist.exception;

public class EmpDataException extends Exception {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpDataException(String message) {
        super(message);
    }

    public EmpDataException(String message, Throwable cause) {
        super(message, cause);
    }
}
