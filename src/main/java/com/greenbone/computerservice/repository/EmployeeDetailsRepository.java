package com.greenbone.computerservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.greenbone.computerservice.model.Employee;

@Repository
public interface EmployeeDetailsRepository extends CrudRepository<Employee, Integer> {

	Employee findByAbberivation(String abberivation);

}
