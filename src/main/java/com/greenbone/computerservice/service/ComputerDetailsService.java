package com.greenbone.computerservice.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.greenbone.computerservice.model.Computer;
import com.greenbone.computerservice.model.ComputerAndEmployeeInfo;
import com.greenbone.computerservice.model.Employee;
import com.greenbone.computerservice.model.notifyInfo;
import com.greenbone.computerservice.repository.ComputerDetailsRepository;
import com.greenbone.computerservice.repository.EmployeeDetailsRepository;

@Service
public class ComputerDetailsService {
	@Autowired
	private ComputerDetailsRepository repository;
	@Autowired
	private EmployeeDetailsRepository employeeDetailsRepository;
	
	public Computer addComputerToEmployee(Employee employee,Computer computer) {
		computer.setEmployee(employee);
		repository.save(computer);
		return computer;
	}

	public Computer addComputerToEmployee(ComputerAndEmployeeInfo info) {
		Computer computer = new Computer();
		computer.setIpAdress(info.getIpAdress());
		computer.setMacAdress(info.getMacAdress());
		computer.setComputerName(info.getComputerName());
		computer.setDescription(info.getDescription().isBlank()? "" : info.getDescription());
		if(employeeDetailsRepository.findByAbberivation(info.getAbberivation())== null) {
			Employee employee = new Employee();	
			employee.setAbberivation(info.getAbberivation());
			computer.setEmployee(employee);
		}
		else {
			Employee emp = employeeDetailsRepository.findByAbberivation(info.getAbberivation());
			computer.setEmployee(emp);
		if(repository.findByEmployee(emp).size()>=2) {
			String url = "http://localhost:8081/api/notify";
			notifyInfo notifyObj = new notifyInfo();
			notifyObj.setEmployeeAbbreviation(info.getAbberivation());
			notifyObj.setLevel("warning");
			notifyObj.setMessage("more than 2 computers are assigned");
			RestTemplate restTemplate = new RestTemplate();
			restTemplate.postForObject(url,notifyObj, Object.class);
			}
		}
		repository.save(computer);
		return computer;
	}
	public Computer updateComputerToEmployee(ComputerAndEmployeeInfo info) {
		Computer computer = repository.findByMacAdress(info.getMacAdress());
		if(employeeDetailsRepository.findByAbberivation(info.getAbberivation())== null) {
			Employee employee = new Employee();	
			employee.setAbberivation(info.getAbberivation());
			computer.setEmployee(employee);
		}
		else {
			Employee emp = employeeDetailsRepository.findByAbberivation(info.getAbberivation());
			computer.setEmployee(emp);
			if(repository.findByEmployee(emp).size()>=2) {
				String url = "http://localhost:8081/api/notify";
				notifyInfo notifyObj = new notifyInfo();
				notifyObj.setEmployeeAbbreviation(info.getAbberivation());
				notifyObj.setLevel("warning");
				notifyObj.setMessage("more than 2 computers are assigned");
				RestTemplate restTemplate = new RestTemplate();
				restTemplate.postForObject(url,notifyObj, Object.class);
				}
		}
		repository.save(computer);
		return computer;
	}
	
	public Computer removeComputerFromEmp(ComputerAndEmployeeInfo info) {
		Computer computer = repository.findByMacAdress(info.getMacAdress());
		computer.setEmployee(null);
		repository.save(computer);
		return computer;
		
	}
	  public List<Computer> fetchComputersForEmployee(String abbrevation ) { 
		  Employee employee = employeeDetailsRepository.findByAbberivation(abbrevation);
	  List<Computer> computer = repository.findByEmployee(employee);
	  return computer;
	  
	  }
	  
	  public List<Computer> fetchAllComputers() { 
	  List<Computer> computer = new ArrayList<>();
	  repository.findAll().forEach(computer :: add);
	  return computer;
	  
	  }
	  
	  public Optional<Computer> fetchComputerById(int id) { 
		  return repository.findById(id);
		  
	 }
}
