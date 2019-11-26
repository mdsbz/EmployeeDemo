/**
 * 
 */
package com.societe.employeeDemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.societe.employeeDemo.model.EmployeeMaster;

/**
 * @author Md Sbz
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeMaster, Long> {

	@Query("SELECT n FROM EmployeeMaster n ORDER BY n.firstName ASC")
	public List<EmployeeMaster> findAllByFirstNameAsc();

}
