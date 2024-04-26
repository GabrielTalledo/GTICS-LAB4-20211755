package com.example.lab4_20211755.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "departments")
public class Department {
    @Id
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name",nullable = false)
    private String departmentName;

    @Column(name = "manager_id")
    private Integer managerId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;


}
