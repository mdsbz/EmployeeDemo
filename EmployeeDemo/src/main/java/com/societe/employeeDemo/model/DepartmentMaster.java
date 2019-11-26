/**
 * 
 */
package com.societe.employeeDemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Md Sbz
 *
 */
@Entity
@Table(name="DEPARTMENT")
public class DepartmentMaster {
	
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 56256226849656789L;
	
	@Id
	@Column(name="DEPARTMENT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long deptId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	@Column(name="DESCRIPTION")
	private String description;

	/**
	 * @return the deptId
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	

}
