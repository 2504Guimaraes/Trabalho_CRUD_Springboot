package com.classes;

import com.classes.model.Aluno;
import com.classes.model.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EstudanteController {

    @Autowired
    private ApplicationContext context;

    // Deixando página de Criação de Alunos
    // como default (index) entre os html's.

    @GetMapping("/")
    public String gerarNovoObjAluno(Model model) {
        model.addAttribute("novo_aluno", new Aluno());
        return "criarAluno";
    }

    @PostMapping("/todosOsAlunos")
    public String inserirAluno(@ModelAttribute Aluno novo_aluno) {
        AlunoService alunoDAO = context.getBean(AlunoService.class);
        alunoDAO.inserir(novo_aluno);
        return "criarAluno"; // por enquanto ñ encaminho p/ nenhuma pág.
    }
}
