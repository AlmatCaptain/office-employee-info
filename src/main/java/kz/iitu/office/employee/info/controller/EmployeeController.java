package kz.iitu.office.employee.info.controller;

import kz.iitu.office.employee.info.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @GetMapping("/")
    public List<Employee> getAll() {
        List<Employee> list = Arrays.asList(
                new Employee(2001L, "Almat", "123123"),
                new Employee(2002L, "Zhandos", "12333")
        );
        return list;
    }
}
