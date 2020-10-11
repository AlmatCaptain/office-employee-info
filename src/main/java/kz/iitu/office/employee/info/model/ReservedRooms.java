package kz.iitu.office.employee.info.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString(exclude = "employee")
public class ReservedRooms {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_id")
    private Long employeeId;
    @Column(name = "room_number")
    private String roomNumber;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "to_date")
    private LocalDate toDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", insertable = false, updatable = false)
    private Employee employee;

}