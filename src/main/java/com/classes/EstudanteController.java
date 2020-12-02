package com.classes;

import com.classes.model.Aluno;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EstudanteController {

    @GetMapping("/")
    public String gerarNovoObjAluno(Model model) {
        model.addAttribute("novo_aluno", new Aluno());
        return "criarAluno";
    }
}
