package com.webonise.vaar.user;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


import com.webonise.vaar.annotationinterface.GridColumn;
import com.webonise.vaar.annotationinterface.SearchColumn;

@Entity
@Table(name="Employee")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="Emp_id")
	@SearchColumn(label = "Employee Id",type="Long")
    @GridColumn
	private int EmployeeId;
	
	
	@Column(name="Emp_name")
	@SearchColumn(label = "Employee Name",type="String")
    @GridColumn
	private String EmployeeName;

	@Column(name="Dept_id")
	@GridColumn
	private int DepartmentId;
	@Column(name="Emp_DOB")
	@GridColumn
	private Date DOB;

	public Employee() {
	}

	public Employee(int id, String empName, int deptId) {
		this.EmployeeId = id;
		this.EmployeeName = empName;
		this.DepartmentId = deptId;
		this.DOB = null;
	}

	public int getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public int getDepartmentId() {
		return DepartmentId;
	}

	public void setDepartmentId(int departmentId) {
		DepartmentId = departmentId;
	}

	public Date getDOB() {
		return DOB;
	}

	public void setDOB(Date dOB) {
		DOB = dOB;
	}
}
