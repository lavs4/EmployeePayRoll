package com.emppayroll.dto;

public class EmployeePayRollDTO {
	private long id;
	private String name;
	private double salary;
    public EmployeePayRollDTO() {}
	public EmployeePayRollDTO(long id, double salary, String name) {
		this.id = id;
		this.salary = salary;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", salary=" + salary +
				'}';
	}
}