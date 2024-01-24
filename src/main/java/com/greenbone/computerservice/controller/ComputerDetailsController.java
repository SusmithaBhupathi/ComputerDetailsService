package com.greenbone.computerservice.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.greenbone.computerservice.model.Computer;
import com.greenbone.computerservice.model.ComputerAndEmployeeInfo;
import com.greenbone.computerservice.service.ComputerDetailsService;

@RestController
public class ComputerDetailsController {
	
	@Autowired
	private ComputerDetailsService computerDetailsService;
	
	@PostMapping("/addComputerToEmp")
	public ResponseEntity<Computer> addComputerToEmployee (@RequestBody ComputerAndEmployeeInfo info) {
		return new ResponseEntity<>(computerDetailsService.addComputerToEmployee(info), HttpStatus.CREATED); 
	}

	@GetMapping("/employee-ComputerDetails")
	public List<Computer> fetchComputersForEmployee (@RequestHeader String abbrevation) {
		return	computerDetailsService.fetchComputersForEmployee(abbrevation); 
	}

	@GetMapping("/getAllComputerDetails")
	public List<Computer> fetchAllComputers () {
		return computerDetailsService.fetchAllComputers(); 
	}
	
	@GetMapping("/getComputerById")
	public Optional<Computer> fetchComputerById (@RequestParam int id) {
		return computerDetailsService.fetchComputerById(id); 
	}
	
	@PutMapping("/assignComputer")
	public ResponseEntity<Computer> updateComputerToEmployee (@RequestBody ComputerAndEmployeeInfo info) {
		return new ResponseEntity<>(computerDetailsService.updateComputerToEmployee(info), HttpStatus.OK); 
	} 
	
	@PutMapping("/removeComputerFromEmp")
	public ResponseEntity<Computer> removeComputerFromEmp (@RequestBody ComputerAndEmployeeInfo info) {
		return new ResponseEntity<>(computerDetailsService.removeComputerFromEmp(info), HttpStatus.OK); 
	} 
	
}
