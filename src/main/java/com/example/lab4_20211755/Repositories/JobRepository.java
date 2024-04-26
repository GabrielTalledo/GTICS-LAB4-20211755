package com.example.lab4_20211755.Repositories;

import com.example.lab4_20211755.Entities.Employee;
import com.example.lab4_20211755.Entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

}
