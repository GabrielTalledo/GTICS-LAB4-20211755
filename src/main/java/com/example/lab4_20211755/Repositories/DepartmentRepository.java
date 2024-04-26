package com.example.lab4_20211755.Repositories;

import com.example.lab4_20211755.Entities.Department;
import com.example.lab4_20211755.Entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
