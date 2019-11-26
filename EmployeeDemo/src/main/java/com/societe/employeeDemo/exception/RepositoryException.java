/**
 * 
 */
package com.societe.employeeDemo.exception;

/**
 * @author Md Sbz
 *
 */
public class RepositoryException extends ApplicationException{

	private static final long serialVersionUID = 123597336748624L;

	private String exceptionMessage;

	public RepositoryException() {
		super();
	}

	public RepositoryException(String err) {
		super(err);
		exceptionMessage=err;
	}

	public String getMessage() {
		return exceptionMessage;
	}

	public RepositoryException(String err,Throwable e) {
		super(err,e);
	}

}
