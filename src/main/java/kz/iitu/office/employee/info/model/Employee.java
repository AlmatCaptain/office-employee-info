package kz.iitu.office.employee.info.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Employee {
    private Long id;
    private String username;
    private String password;

    public Employee(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
