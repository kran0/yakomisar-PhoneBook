package com.example.phonebook.repositories;

import com.example.phonebook.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRep extends CrudRepository<Employee, Long> {
    <List>Employee findByName(String name);
}
