/**
 * 
 */
package com.societe.employeeDemo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.societe.employeeDemo.exception.ServiceException;
import com.societe.employeeDemo.model.DepartmentMaster;
import com.societe.employeeDemo.model.EmployeeMaster;
import com.societe.employeeDemo.repository.EmployeeRepository;
import com.societe.employeeDemo.request.EmployeeRequest;
import com.societe.employeeDemo.response.EmployeeResponse;
import com.societe.employeeDemo.service.EmployeeService;

/**
 * @author Md Sbz
 *
 */
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	/**
	 * <p>
	 * Service implementation of get employees detail
	 * </p>
	 */

	@Override
	public List<EmployeeResponse> getEmployee() throws ServiceException {
		List<EmployeeResponse> employeeResponses = null;
		List<EmployeeMaster> employeeMasters = employeeRepository.findAllByFirstNameAsc();
		if (Objects.nonNull(employeeMasters) && !employeeMasters.isEmpty()) {
			employeeResponses = new ArrayList<>();
			for (EmployeeMaster employeeMaster : employeeMasters) {
				EmployeeResponse employeeResponse = new EmployeeResponse();
				BeanUtils.copyProperties(employeeMaster, employeeResponse);
				employeeResponses.add(employeeResponse);
			}
		}
		return employeeResponses;
	}

	/**
	 * <p>
	 * Service implementation of add employee details
	 * </p>
	 */

	@Override
	public EmployeeResponse addEmployee(EmployeeRequest employeeRequest) throws ServiceException {
		EmployeeResponse employeeResponse = null;
		if (Objects.nonNull(employeeRequest)) {
			EmployeeMaster employeeMaster = this.populateVales(employeeRequest);
			employeeRepository.save(employeeMaster);
			employeeResponse = new EmployeeResponse();
			BeanUtils.copyProperties(employeeMaster, employeeResponse);

		}
		return employeeResponse;
	}

	/**
	 * <p>
	 * method to populate the values
	 * </p>
	 * 
	 * @param employeeRequest
	 * @return
	 */

	private EmployeeMaster populateVales(EmployeeRequest employeeRequest) {
		EmployeeMaster employeeMaster = new EmployeeMaster();
		if (Objects.nonNull(employeeRequest.getFirstName()))
			employeeMaster.setFirstName(employeeRequest.getFirstName());
		if (Objects.nonNull(employeeRequest.getLastName()))
			employeeMaster.setLastName(employeeRequest.getLastName());
		if (Objects.nonNull(employeeRequest.getGender()))
			employeeMaster.setGender(employeeRequest.getGender());
		if (Objects.nonNull(employeeRequest.getDateOfBirth()))
			employeeMaster.setDateOfBirth(employeeRequest.getDateOfBirth());
		if (Objects.nonNull(employeeRequest.getDepartmentId())) {
			DepartmentMaster departmentMaster = new DepartmentMaster();
			departmentMaster.setDeptId(employeeRequest.getDepartmentId());
			employeeMaster.setDepartmentMaster(departmentMaster);
		}
		return employeeMaster;
	}

}
