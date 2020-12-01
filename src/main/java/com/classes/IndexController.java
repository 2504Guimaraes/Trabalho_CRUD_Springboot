package com.classes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ApplicationContext context;

    // Deixando página de Criação de Alunos
    // como default (index) entre os html's.

    @GetMapping("/")
    public String irAHome() {
        return "criarAluno";
    }
}
