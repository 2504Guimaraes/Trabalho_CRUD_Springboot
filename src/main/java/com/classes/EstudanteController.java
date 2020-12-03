package com.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.classes.model.Aluno;
import com.classes.model.AlunoService;

@Controller
public class EstudanteController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/") // Definindo criaraluno.html como root pelo path da url
    public String cadastrarAluno(Model model) {
        model.addAttribute("aluno", new Aluno());
        return "criaraluno";
    }

    @PostMapping("/alunocadastrado")
    public String acaoCadastrar(@ModelAttribute Aluno aluno, Model model) {
        model.addAttribute("aluno", aluno);
        AlunoService alunoService = context.getBean(AlunoService.class);
        alunoService.inserirAluno(aluno);
        return "sucessocadastro";
    }
}
