package com.example.lab4_20211755.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VistaPrincipalController {

    @GetMapping(value = {"", "/"})
    public String mostrarVistaPrincipal() {
        return "VistaPrincipal";
    }
}
