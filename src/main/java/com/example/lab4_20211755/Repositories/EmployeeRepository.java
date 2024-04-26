package com.example.lab4_20211755.Repositories;

import com.example.lab4_20211755.Entities.Employee;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "UPDATE employees set job_id = ?1 , department_id = ?2 WHERE employee_id = ?3")
    void editarEmployee(String jobId, Integer departmentId, Integer id);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
            value = "DELETE FROM employees WHERE employee_id = ?1")
    void eliminarEmployee(Integer id);

    @Query(nativeQuery = true,
            value = "SELECT e.* FROM employees e LEFT JOIN jobs j ON j.job_id = e.job_id LEFT JOIN departments d ON d.department_id = e.department_id LEFT JOIN locations l ON l.location_id = d.location_id\n" +
                    "WHERE e.first_name like concat('%',?1,'%') OR\n" +
                    "e.last_name like concat('%',?1,'%') OR\n" +
                    "j.job_title like concat('%',?1,'%') OR\n" +
                    "l.city like concat('%',?1,'%')")
    List<Employee> listarPorBusqueda(String busqueda);
}
