/**
 * 
 */
package com.societe.employeeDemo.exception;

/**
 * @author Md Sbz
 *
 */
public class ApplicationException extends Exception {

	private static final long serialVersionUID = 198539733667748624L;

	private String exceptionMessage;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String err) {
		super(err);
		exceptionMessage = err;
	}

	public ApplicationException(String err, Throwable e) {

		this.exceptionMessage = err;
		this.initCause(e);
	}

	public void setCause(Throwable e) {
		this.initCause(e);
	}

	public String getErrorMessage() {
		return exceptionMessage;
	}

	public String getFaultCode() {
		return exceptionMessage;
	}

}
