/**
 * 
 */
package com.societe.employeeDemo.exception;

/**
 * @author Md Sbz
 *
 */
public class ServiceException extends  ApplicationException{
	
	private static final long serialVersionUID=123597336748624L;
	
	private String exceptionMessage;
	
	public ServiceException() {
		super();
	}
	
	public ServiceException(String err) {
		super(err);
		exceptionMessage=err;
	}
	public String getMessage() {
		return exceptionMessage;
	}
	
	public ServiceException(String err,Throwable e) {
		super(err,e);
	}

}
