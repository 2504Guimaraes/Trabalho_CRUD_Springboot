package com.classes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AlunoService {

    @Autowired
    AlunoDAO alunoDAO;

    public void insert(Aluno aluno) {
        alunoDAO.insert(aluno);
    }

    public List<Map<String, Object>> getAllAlunos() {
        return alunoDAO.getAllAlunos();
    }

    public void deletarAluno(int idAluno) {
        alunoDAO.deletarAluno(idAluno);
    }
}
