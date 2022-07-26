package com.example.phonebook;

import com.example.phonebook.domain.Codes;
import com.example.phonebook.domain.Employee;
import com.example.phonebook.repositories.CodesRep;
import com.example.phonebook.repositories.EmployeeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class PhoneBookController {

    @Autowired
    private EmployeeRep employeeRep;

    @Autowired
    private CodesRep codeRep;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Map<String, Object> model) {
        model.put("name", name);
        return "greeting";
    }

    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Employee> employees = employeeRep.findAll();
        Iterable<Codes> codes = codeRep.findAll();

        model.put("employees", employees);
        model.put("codes", codes);

        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam String phone, @RequestParam String workplace, Map<String, Object> model) {
        Employee employee = new Employee(name, phone, workplace);

        employeeRep.save(employee);
        Iterable<Employee> employees = employeeRep.findAll();
        model.put("employees", employees);

        return "main";
    }

    @GetMapping("/search")
    public String search(Map<String, Object> model) {
        Iterable<Employee> employees = employeeRep.findAll();
        model.put("employees", employees);

        return "search";
    }
    @PostMapping("/search")
    public String find(@RequestParam String name, @RequestParam String phone, @RequestParam String workplace, Map<String, Object> model) {
        Iterable<Employee> employees;

        if (name != null && !name.isEmpty()) {
            employees = employeeRep.findByNameLike(name);
        } else {
            employees = employeeRep.findAll();
        }
        model.put("employees", employees);

        return "search";
    }
}
