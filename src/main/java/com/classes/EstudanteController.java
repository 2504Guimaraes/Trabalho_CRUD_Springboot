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


    @GetMapping("/") /* Definindo Index */
    public String index() {
        return "index";
    }

    /* Definindo outras rotas do (Estudante / Aluno) ... */

    @GetMapping("/criar")
    public String criarAluno(Model model) {
        model.addAttribute("novo_aluno", new Aluno());
        return "criarAluno";
    }

    @PostMapping("/criado") /* Criando novo Aluno */
    public String acaoCadastrar(@ModelAttribute Aluno novo_aluno, Model model) {
        model.addAttribute("novo_aluno", novo_aluno);
        AlunoService pdao = context.getBean(AlunoService.class);
        pdao.insert(novo_aluno);
        return "alunoCriado";
    }

    @GetMapping("/apagar")
    public String apagarAluno() {
        return "apagarAluno";
    }

    @GetMapping("/editar")
    public String editarAluno() {
        return "editarAluno";
    }

    /* --- Definindo controllers p/ chegar às listas de alunos: --- */

    @GetMapping("/todos")
    public String listaTodos() {
        return "todosOsAlunos";
    }

    @GetMapping("/homens")
    public String listaHomens() {
        return "alunosHomens";
    }

    @GetMapping("/mulheres")
    public String listaMulheres() {
        return "alunasMulheres";
    }

    @GetMapping("/reprovados")
    public String listaReprovados() {
        return "alunosReprovados";
    }

    @GetMapping("/si")
    public String listaSi() {
        return "alunosDeSi";
    }

    @GetMapping("/ads")
    public String listaADS() {
        return "alunosDeAds";
    }

    @GetMapping("/log")
    public String listaLog() {
        return "alunosDeLog";
    }

    @GetMapping("/gp")
    public String listaGp() {
        return "alunosDeGp";
    }

}
