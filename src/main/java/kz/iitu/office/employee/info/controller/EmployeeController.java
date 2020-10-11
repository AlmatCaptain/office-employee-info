package kz.iitu.office.employee.info.controller;

import kz.iitu.office.employee.info.model.Employee;
import kz.iitu.office.employee.info.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getListEmployee() {
        return employeeService.getListEmployee();
    }

    @GetMapping("/{name}")
    public Employee getEmployeeByName(@PathVariable String name){
        return employeeService.getEmployeeByName(name);
    }

    @PostMapping("/registration")
    public void addEmployee(@RequestBody Employee e) {
        employeeService.addEmployee(e);
    }

    @PutMapping("/update/{id}")
    public void updateMember(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        employeeService.updateEmployee(id, employee);
    }

    @PatchMapping("/update/{id}")
    public void updateUserName(@PathVariable Long id, @RequestParam String name) {
        employeeService.updateName(id, name);
    }

    @PatchMapping("/role/{id}")
    public void updateUserRole(@PathVariable Long id, @RequestParam String role) {
        employeeService.updateRole(id, role);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @PostMapping("/add")
    public void createEmployee(@RequestBody Employee e) {
        employeeService.addEmployee(e);
    }


}
