/**
 * 
 */
package com.societe.employeeDemo.service;

import java.util.List;

import com.societe.employeeDemo.exception.ServiceException;
import com.societe.employeeDemo.request.EmployeeRequest;
import com.societe.employeeDemo.response.EmployeeResponse;

/**
 * @author Md Sbz
 *
 */
public interface EmployeeService {

	/**
	 * 
	 * @return
	 * @throws ServiceException
	 */
	public List<EmployeeResponse> getEmployee() throws ServiceException;

	/**
	 * 
	 * @param employeeRequest
	 * @return
	 * @throws ServiceException
	 */

	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) throws ServiceException;

}
