package com.classes.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class AlunoDAO {

    @Autowired
    DataSource dataSource;

    JdbcTemplate jdbc;

    // inicializat Java Database Conectivity c/ Base de Dados
    // (PostGreSQL Heroku):

    @PostConstruct
    private  void  initialize() {
        jdbc = new JdbcTemplate(dataSource);
    }

    public void inserir(Aluno alunoGerado)
    {
        String sql = "insert into Alunos" +
                "(nm_aluno, sg_sexoAluno, cd_curso, qt_notaAluno, qt_idade)" +
                "values(?, ?, ?, ?, ?)";

        jdbc.update(sql, new Object[] {
                alunoGerado.getNm(),
                alunoGerado.getSgSx(),
                alunoGerado.getIdCurso(),
                alunoGerado.getNota(),
                alunoGerado.getIdade()
        });
    }
}
