package edu.trial.itcompany.controller;

import edu.trial.itcompany.DBmodel.Employee;
import edu.trial.itcompany.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Employee> findAll (){
        return employeeService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Employee employee) {
        employeeService.update(employee);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
    }
}
