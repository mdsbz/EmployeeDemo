/**
 * 
 */
package com.societe.employeeDemo.servive.imp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.societe.employeeDemo.exception.RepositoryException;
import com.societe.employeeDemo.exception.ServiceException;
import com.societe.employeeDemo.model.DepartmentMaster;
import com.societe.employeeDemo.model.EmployeeMaster;
import com.societe.employeeDemo.repository.EmployeeRepository;
import com.societe.employeeDemo.request.EmployeeRequest;
import com.societe.employeeDemo.service.EmployeeService;

/**
 * @author Md Sbz
 *
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceImpTest  {

	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeRepository employeeRepository;
	
	/**
	 * JUnit for get all employees details
	 *  
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void getEmployeeTest() throws ServiceException,RepositoryException{
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setEmployeeId(1l);
		employeeMaster.setFirstName("Md");
		employeeMaster.setLastName("Shahbaz");
		DepartmentMaster departmentMaster = new DepartmentMaster();
		departmentMaster.setDeptId(1l);
		departmentMaster.setDepartmentName("Finance");
		departmentMaster.setDescription("Finance description");
		employeeMaster.setDepartmentMaster(departmentMaster);
		employeeMaster.setGender("Male");
		List<EmployeeMaster> employeeMasters = new ArrayList<>();
		when(employeeRepository.findAll()).thenReturn((List<EmployeeMaster>) Stream.of(employeeMasters));
		assertEquals(1, employeeService.getEmployee().size());
		assertThat(employeeService.getEmployee().get(0).getFirstName().equals("Md"));
		assertNotEquals(employeeService.getEmployee().get(0).getFirstName(), "XYZ");
		assertEquals("Shahbaz", employeeService.getEmployee().get(0).getLastName());
		assertEquals("Finance", employeeService.getEmployee().get(0).getDepartmentId());
	}
	
	/**
	 * JUnit for save employee details
	 *  
	 */
	@Test
	public void addEmployeeTest() throws ServiceException,RepositoryException{
		EmployeeMaster employeeMaster = new EmployeeMaster();
		employeeMaster.setEmployeeId(1l);
		employeeMaster.setFirstName("Md");
		employeeMaster.setLastName("Shahbaz");
		DepartmentMaster departmentMaster = new DepartmentMaster();
		departmentMaster.setDeptId(1l);
		departmentMaster.setDepartmentName("Finance");
		departmentMaster.setDescription("Finance description");
		employeeMaster.setDepartmentMaster(departmentMaster);
		employeeMaster.setGender("Male");
		EmployeeRequest employeeRequest= new EmployeeRequest();
		employeeMaster.setFirstName("Md");
		employeeMaster.setLastName("Shahbaz");
		when(employeeRepository.save(employeeMaster)).thenReturn(employeeMaster);
		assertEquals(employeeMaster.getDepartmentMaster().getDeptId(), employeeService.addEmployee(employeeRequest).getDepartmentId());
		assertEquals(employeeMaster.getFirstName() , employeeService.addEmployee(employeeRequest).getFirstName());
		assertNotEquals(employeeMaster.getFirstName(), employeeService.addEmployee(employeeRequest).getFirstName());
	}

}
