package com.greenbone.computerservice.model;

public class ComputerAndEmployeeInfo {

	private String macAdress;
	private String ipAdress;
	private String computerName;
	private String description; 
	private String abberivation;
	public String getMacAdress() {
		return macAdress;
	}
	public void setMacAdress(String macAdress) {
		this.macAdress = macAdress;
	}
	public String getIpAdress() {
		return ipAdress;
	}
	public void setIpAdress(String ipAdress) {
		this.ipAdress = ipAdress;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getAbberivation() {
		return abberivation;
	}
	public void setAbberivation(String abberivation) {
		this.abberivation = abberivation;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
}
