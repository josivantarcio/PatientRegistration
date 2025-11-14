package com.jtarcio.cadastro.pessoas.pacientes.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PatientController {

    @GetMapping("/pacientes")
    public String boasVindasPatient(){

        return "Seja bem-vindo Paciente!";
    }
}
