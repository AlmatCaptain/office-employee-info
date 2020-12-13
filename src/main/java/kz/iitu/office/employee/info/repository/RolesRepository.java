package kz.iitu.office.employee.info.repository;

import kz.iitu.office.employee.info.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role, Long> {}
