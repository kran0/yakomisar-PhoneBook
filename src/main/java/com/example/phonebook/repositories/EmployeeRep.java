package com.example.phonebook.repositories;

import com.example.phonebook.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
public interface EmployeeRep extends CrudRepository<Employee, Long> {
    List<Employee> findByFirstNameLike(String firstName);
}
