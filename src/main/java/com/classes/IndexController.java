package com.classes;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/")
    public String irAHome(Model model) {

        String test = "Testando página inicial (criarAluno.html)... :D";

        model.addAttribute("var_teste_mostrada", test);
        return "criarAluno";
    }
}
