package kz.iitu.office.employee.info.service;


import kz.iitu.office.employee.info.model.Employee;
import kz.iitu.office.employee.info.model.Role;
import kz.iitu.office.employee.info.repository.EmployeeRepository;
import kz.iitu.office.employee.info.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    RestTemplate restTemplate;

    private final EmployeeRepository employeeRepository;
    private final RolesRepository rolesRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, RolesRepository rolesRepository) {
        this.employeeRepository = employeeRepository;
        this.rolesRepository = rolesRepository;
    }

    public List<Employee> getListEmployee() {
        return employeeRepository.findAll();
    }

    public void addEmployee(Employee e) {
        List<Role> role = rolesRepository.findAll();

        for (Role r : role) {
            if (r.getId() == 2L) {
                System.out.println(r);
                e.setRoles(Collections.singletonList(r));
            }
        }
        employeeRepository.saveAndFlush(e);
    }

    public void updateEmployee(Long id, Employee employee) {
        Employee e = employeeRepository.findById(id)
                .orElse(null);

        if (e != null) {
            e.setUsername(employee.getUsername());
            e.setPassword(employee.getPassword());

            employeeRepository.saveAndFlush(e);
        }
    }

    public void updateName(Long id, String name) {
        Employee employee = employeeRepository.findById(id)
                .get();
        employee.setUsername(name);
        employeeRepository.saveAndFlush(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public void updateRole(Long id, String role) {
        Employee employee = employeeRepository.findById(id).get();

        Employee e = new Employee();
        e.setId(employee.getId());
        e.setUsername(employee.getUsername());
        e.setPassword(employee.getPassword());
        e.setReservedRooms(employee.getReservedRooms());

        Role[] roles = restTemplate.getForEntity("http://office-acl-api:8083/roles", Role[].class).getBody();

        for (Role r : roles) {
            if (role.equals("ADMIN")) {
                if (r.getId() == 2L)
                    e.setRoles(Collections.singletonList(r));
            } else if (role.equals("USER")) {
                if (r.getId() == 1L)
                    e.setRoles(Collections.singletonList(r));
            }
        }

        employeeRepository.save(e);
    }

    public Employee getEmployeeByName(String name) {
        return employeeRepository.findByUsername(name);
    }


    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).get();
    }
}
