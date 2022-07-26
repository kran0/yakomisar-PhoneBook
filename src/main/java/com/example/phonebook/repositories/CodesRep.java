package com.example.phonebook.repositories;

import com.example.phonebook.domain.Codes;
import com.example.phonebook.domain.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CodesRep extends CrudRepository<Codes, Long> {
}
