package com.example.lab4_20211755.Controllers;

import com.example.lab4_20211755.Entities.Employee;
import com.example.lab4_20211755.Repositories.DepartmentRepository;
import com.example.lab4_20211755.Repositories.EmployeeRepository;
import com.example.lab4_20211755.Repositories.JobRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    //Repositorios
    final EmployeeRepository employeeRepository;
    final JobRepository jobRepository;
    final DepartmentRepository  departmentRepository;
    public EmployeeController(EmployeeRepository employeeRepository,JobRepository jobRepository,DepartmentRepository  departmentRepository){
        this.employeeRepository = employeeRepository;
        this.jobRepository = jobRepository;
        this.departmentRepository = departmentRepository;
    }

    //Métodos
    @GetMapping(value = {"", "/listar"})
    public String listaTotalEmployees(@RequestParam(value = "busqueda", required = false) String busqueda,Model model) {
        if(busqueda == null || busqueda.isEmpty()){
            model.addAttribute("listaEmployees", employeeRepository.findAll());
        }else{
            model.addAttribute("listaEmployees", employeeRepository.listarPorBusqueda(busqueda));
        }

        return "EmployeeListado";
    }

    @PostMapping(value = {"/listar"})
    public String listaTotalEmployeesBusqueda(@RequestParam(value = "busqueda", required = false) String busqueda,Model model) {
        if(busqueda == null || busqueda.isEmpty()){
            model.addAttribute("listaEmployees", employeeRepository.findAll());
        }else{
            model.addAttribute("listaEmployees", employeeRepository.listarPorBusqueda(busqueda));
        }

        return "EmployeeListado";
    }

    @GetMapping("/edit")
    public String formularioEditarEmployee(@RequestParam("id") Integer id, Model model) {

        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();
            model.addAttribute("employee", employee);
            model.addAttribute("employeeId",id);
            model.addAttribute("listaJobs",jobRepository.findAll());
            model.addAttribute("listaDepartments",departmentRepository.findAll());
            return "EmployeeEditFormulario";
        } else {
            return "redirect:/employee";
        }
    }

    @PostMapping("/edit")
    public String EditarEmployee(@RequestParam("jobId") String jobId,
                                 @RequestParam("departmentId") Integer departmentId,
                                 @RequestParam("id") Integer id) {

        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            Employee employee = optEmployee.get();
            employeeRepository.editarEmployee(jobId,departmentId,id);
        }

        return "redirect:/employee";
    }

    @GetMapping("/delete")
    public String EditarEmployee(@RequestParam("id") Integer id) {

        Optional<Employee> optEmployee = employeeRepository.findById(id);

        if (optEmployee.isPresent()) {
            employeeRepository.eliminarEmployee(id);
        }

        return "redirect:/employee";
    }


}
