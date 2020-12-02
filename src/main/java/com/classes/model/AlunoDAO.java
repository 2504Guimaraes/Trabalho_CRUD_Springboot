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

    public void inserirAluno(Aluno aluno)
    {
        String sql = "insert into Alunos" +
                "(nm_aluno, sg_sexoaluno, cd_curso, qt_notaaluno, qt_idade)" +
                "values(?,?,?,?,?)";

        jdbc.update(sql, new Object[] {
                aluno.getNome(),
                aluno.getSexo(),
                aluno.getCodigoCurso(),
                aluno.getNota(),
                aluno.getIdade()
        });
    }
}
