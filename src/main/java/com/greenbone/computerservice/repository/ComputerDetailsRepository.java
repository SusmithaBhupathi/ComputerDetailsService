package com.greenbone.computerservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.greenbone.computerservice.model.Computer;
import com.greenbone.computerservice.model.Employee;

@Repository
public interface ComputerDetailsRepository extends CrudRepository<Computer, Integer> {
	List<Computer> findByEmployee(Employee employee);
	Computer findByMacAdress(String macAdress);

}
