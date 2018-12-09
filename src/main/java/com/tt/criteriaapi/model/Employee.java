package com.tt.criteriaapi.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	
	@Column(name="employee_id")
	private int employeeId;

	@Column(name= "name")
	private String employeeName;
	
	@Column(name= "department")
	private String employeeDepartment;
	@Column(name= "hire_date")
	private LocalDate employeeHireDate;
	@Column(name= "salary")
	private long employeeSalary;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int employeeId, String employeeName, String employeeDepartment, LocalDate employeeHireDate,
			long employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeHireDate = employeeHireDate;
		this.employeeSalary = employeeSalary;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public LocalDate getEmployeeHireDate() {
		return employeeHireDate;
	}
	public void setEmployeeHireDate(LocalDate employeeHireDate) {
		this.employeeHireDate = employeeHireDate;
	}
	public long getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(long employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeDepartment="
				+ employeeDepartment + ", employeeHireDate=" + employeeHireDate + ", employeeSalary=" + employeeSalary
				+ "]";
	}

}
