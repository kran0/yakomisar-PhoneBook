package com.example.phonebook;

import com.example.phonebook.domain.Codes;
import com.example.phonebook.domain.Employee;
import com.example.phonebook.repositories.CodesRep;
import com.example.phonebook.repositories.EmployeeRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

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
    public String add(@RequestParam String firstName, @RequestParam String secondName, @RequestParam String email, @RequestParam String code, @RequestParam String phone, @RequestParam String workplace, Map<String, Object> model) {
        Employee employee = new Employee(firstName, secondName, email, code+'-'+phone,  workplace);

        employeeRep.save(employee);
        Iterable<Employee> employees = employeeRep.findAll();
        Iterable<Codes> codes = codeRep.findAll();

        model.put("employees", employees);
        model.put("codes", codes);

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
            employees = employeeRep.findByFirstNameLike(name);
        } else {
            employees = employeeRep.findAll();
        }
        model.put("employees", employees);

        return "search";
    }
    @GetMapping("/empcard/{id}")
    public String getPatientInfo(@PathVariable("id") Integer id, Map<String, Object> model) {

        Employee employees = employeeRep.findById(id).orElse(null);

        model.put("employees", employees);

        return "empcard";
    }

    @PostMapping(value = "/empcard/{id}", params = "save")
    public String save(@PathVariable("id") Integer id,
                       @RequestParam String firstName,
                       @RequestParam String secondName,
                       @RequestParam String email,
                       //RequestParam String code,
                       @RequestParam String phone,
                       @RequestParam String workplace,
                       Map<String, Object> model) {

        Employee employee = employeeRep.findById(id).orElse(null);
        if (employee != null) {
            employee.setFirstName(firstName);
            employee.setSecondName(secondName);
            employee.setEmail(email);
            employee.setPhone(phone);
            employee.setWorkplace(workplace);
            employeeRep.save(employee);
        }
        return "redirect:/main";
    }

    @PostMapping(value = "/empcard/{id}", params = "delete")
    public String delete(@PathVariable("id") Integer id) {
        Employee employee = employeeRep.findById(id).orElse(null);
        if (employee != null) {
            employeeRep.deleteById(id);
        }
        return "redirect:/main";
    }
    @PostMapping(value = "/empcard/{id}", params = "cancel")
    public String cancel() {
        return "redirect:/main";
    }
}
