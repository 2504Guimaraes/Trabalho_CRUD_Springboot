package com.classes;

import com.classes.model.Aluno;
import com.classes.model.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

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
        model.addAttribute("aluno", new Aluno());
        return "criarAluno";
    }

    @PostMapping("/criado") /* Criando novo Aluno */
    public String acaoCadastrar(@ModelAttribute Aluno aluno, Model model) {
        model.addAttribute("aluno", aluno);
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        aluno_dao.insert(aluno);
        return "alunoCriado";
    }

    @PostMapping("/apagar/{idAluno}")
    public String apagarAluno(@PathVariable("idAluno") int idAluno) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        aluno_dao.deletarAluno(idAluno);
        return "redirect:/todos";
    }

    /* --- Definindo controllers p/ chegar às listas de alunos: --- */

    @GetMapping("/todos")
    public String listaTodos(Model model) {
        AlunoService aluno_dao = context.getBean(AlunoService.class);
        List<Map<String, Object>> listaAlunos = aluno_dao.getAllAlunos();
        model.addAttribute("allAlunosLista", listaAlunos);
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

    @GetMapping("/ge")
    public String listaGe() {
        return "alunosDeGe";
    }

}
