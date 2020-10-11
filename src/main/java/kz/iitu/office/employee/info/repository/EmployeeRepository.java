package kz.iitu.office.employee.info.repository;

import kz.iitu.office.employee.info.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByUsername(String name);
}
