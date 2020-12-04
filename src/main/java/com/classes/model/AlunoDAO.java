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

    public void insert(Aluno aluno)
    {
        String sql = "insert into Aluno (nome, sexo, codigoCurso, nota, idade) values(?,?,?,?,?)";

        jdbc.update(sql, new Object[] {
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getCodigoCurso(),
                aluno.getNota(),
                aluno.getIdade()
        });
    }
}
