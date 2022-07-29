package com.example.phonebook.repositories;

import com.example.phonebook.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRep extends CrudRepository<Employee, Integer> {
    List<Employee> findByFirstNameLike(String firstName);
    List<Employee> findByFirstNameOrSecondNameOrWorkplace(String firstName, String secondName, String workplace);

}
