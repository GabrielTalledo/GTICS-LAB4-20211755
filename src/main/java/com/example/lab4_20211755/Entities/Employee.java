package com.example.lab4_20211755.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "hire_date",nullable = false)
    private Date hireDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "salary")
    private BigDecimal salary;
    @Column(name = "commission_pct")
    private BigDecimal commissionPct;

    @Column(name = "manager_id")
    private Integer manager_id;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "enabled")
    private Integer enabled;

}
