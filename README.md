This service provides the track of the computers issued for the employee, runs on port 8080 for the below HTTP URLs

1. The system administrator wants to be able to get all assigned computers for an employee  with a  
GET request:  localhost:8080/employee-ComputerDetails

2.The system administrator wants to be able to get all computers with a  
GET request: localhost:8080/getAllComputerDetails

3.The system administrator wants to be able to get the data of a single computer with a  
GET request: localhost:8080/getComputerById?id = {ComputerId}

4.The system administrator wants to be able to add a new computer to an employee and the system administrator wants to be informed when an employee is assigned 3 or
more computers with a  
POST request: localhost:8080/addComputerToEmp with following JSON Data
	{
   	"macAdress":"00-B0-D0-63-C2-26",
	"ipAdress": "192.158.1.38",
	"computerName":"DELL",
	"description":"adding to AST",
	"abberivation": "AST"    
	}   

5. The system administrator wants to be able to assign a computer to another employee and the system administrator wants to be informed when an employee is assigned 3 or
more computers with a  
PUT request: localhost:8080/assignComputer with following jsonData
{
   	 "macAdress":"00-B0-D0-63-C2-26",
	"abberivation": "MMU"    
}   

6.The system administrator wants to be able to remove a computer from an employee  with a  
PUT request: localhost:8080/removeComputerFromEmp with following jsonData
{
   	 "macAdress":"00-B0-D0-63-C2-26",
	"abberivation": "MMU"    
}   

build as a Java application
Steps to run as a Java application:
1.Import the project as a Maven Project 
2.Configure buildpath with JDK 17
3. right click on the project and Run As Java Project
