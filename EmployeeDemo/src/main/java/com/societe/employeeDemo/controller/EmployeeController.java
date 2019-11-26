/**
 * 
 */
package com.societe.employeeDemo.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.societe.employeeDemo.exception.RepositoryException;
import com.societe.employeeDemo.exception.ServiceException;
import com.societe.employeeDemo.request.EmployeeRequest;
import com.societe.employeeDemo.response.EmployeeResponse;
import com.societe.employeeDemo.service.EmployeeService;
import com.societe.employeeDemo.util.CommonResponse;
import com.societe.employeeDemo.util.EmployeeConstant;

/**
 * @author Md Shahbaz
 *
 */
@RestController
@RequestMapping(value = "/api")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	/**
	 * <p>
	 * This method is used to get all the employees detail.
	 * </p>
	 * 
	 * @return
	 * @throws ServiceException
	 * @throws RepositoryException
	 */

	@GetMapping(value = "getEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonResponse getEmployee() throws ServiceException, RepositoryException {
		CommonResponse commonResponse = new CommonResponse();
		List<EmployeeResponse> employeeList = employeeService.getEmployee();
		if (Objects.nonNull(employeeList) && !employeeList.isEmpty()) {
			commonResponse.setData(employeeList);
		} else {
			commonResponse.setData(EmployeeConstant.NO_DATA_FOUND);
		}
		commonResponse.setResponseMessage(EmployeeConstant.SUCCESS);
		return commonResponse;
	}
	
	/**
	 * 
	 * <p>
	 * This method is used to save the employee details
	 * </p>
	 * 
	 * @param employeeRequest
	 * @return
	 * @throws ServiceException
	 * @throws RepositoryException
	 */

	@PostMapping(value = "/addEmployee", produces = MediaType.APPLICATION_JSON_VALUE)
	public CommonResponse addEmployee(EmployeeRequest employeeRequest) throws ServiceException, RepositoryException {
		CommonResponse commonResponse = new CommonResponse();
		EmployeeResponse employeeList = employeeService.addEmployee(employeeRequest);
		if (Objects.nonNull(employeeList)) {
			commonResponse.setData(employeeList);
		} else {
			commonResponse.setData(EmployeeConstant.NO_DATA_FOUND);
		}
		commonResponse.setResponseMessage(EmployeeConstant.SUCCESS);
		return commonResponse;
	}

}
