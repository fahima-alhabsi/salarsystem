package com.codeline.sampleProject.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Data
public class Manager extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @OneToOne(cascade = CascadeType.ALL)
    private Employee employee;

    @JoinColumn(name = "team_id", referencedColumnName = "id")
    @OneToMany(cascade = CascadeType.ALL)
    private List<Employee> team;

    private String department;

    private String teamName;


}
