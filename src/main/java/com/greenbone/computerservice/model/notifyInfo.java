package com.greenbone.computerservice.model;

public class notifyInfo {

	private String level ;
	private String employeeAbbreviation;
	private String message;
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getEmployeeAbbreviation() {
		return employeeAbbreviation;
	}
	public void setEmployeeAbbreviation(String employeeAbbreviation) {
		this.employeeAbbreviation = employeeAbbreviation;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
