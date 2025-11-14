package com.jtarcio.cadastro.pessoas.medicos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class DoctorController {

    @GetMapping("/medicos")
    public String bemVindoDoctor(){
        return "Seja Bem-Vindo Doutor";
    }

}
