package com.example.phonebook;

import com.example.phonebook.domain.Employee;
import com.example.phonebook.repositories.EmployeeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private EmployeeRep employeeRep;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Employee> employees = employeeRep.findAll();
        model.put("employees", employees);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String name, @RequestParam String phone, @RequestParam String workplace, Map<String, Object> model) {
        Employee employee = new Employee(name, phone, workplace);

        employeeRep.save(employee);
        Iterable<Employee> employees = employeeRep.findAll();
        model.put("employees", employees);

        return "main";
    }

    @PostMapping("find")
    public String find(@RequestParam String name, @RequestParam String phone, @RequestParam String workplace, Map<String, Object> model) {
        Iterable<Employee> employees;

        if (name != null && !name.isEmpty()) {
            employees = employeeRep.findByName(name);
        } else {
            employees = employeeRep.findAll();
        }
        model.put("employees", employees);

        return "main";
    }
}
