package com.classes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    AlunoDAO alunoDAO;

    public void inserir(Aluno novo_aluno)
    {
        alunoDAO.inserir(novo_aluno);
    }
}
