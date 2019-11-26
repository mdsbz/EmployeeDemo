/**
 * 
 */
package com.societe.employeeDemo.request;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * @author Md Sbz
 *
 */
public class EmployeeRequest {

	@NotNull
	@Size(min=1)
	@Pattern(regexp="^([A-Za-z]+ )+[A-Za-z]+$|^[A-Za-z]+$")
	private String firstName;

	@NotNull
	@Size(min=1)
	@Pattern(regexp="^([A-Za-z]+ )+[A-Za-z]+$|^[A-Za-z]+$")
	private String lastName;
	
	@NotNull
	@Pattern(regexp="^(?:m|M|male|Male|f|F|female|Female)$")
	private String gender;

	@NotNull
	private Date dateOfBirth;
	
	@NotNull
	private Long departmentId;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId the departmentId to set
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	

}
