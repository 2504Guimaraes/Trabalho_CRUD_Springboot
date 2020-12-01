/*
    Script.sql o qual está ligado ao postgre no Heroku
    e fará a modelagem do mesmo.
*/

/*
    Primeiramente criarei entidades as quais diretamente, nunca serão
    manipuladas pelo usuário mas se relacionam e definem carácteristicas do mesmo.
    Por isso devem ser já previamente definidas aqui, no caso; Instituição e Cursos
    que o Aluno pode fazer.
*/

create table if not exists Instituicao (
    cd_instituicao serial not null,
    nm_instituicao varchar(45) ,
    constraint PK_instituicao primary key (cd_instituicao)
);

create table Cursos(
    cd_curso serial not null ,
    nm_curso varchar(45),
    sg_curso char(3),
    cd_instituicao serial,
    constraint PK_Curso primary key (cd_curso),
    constraint FK_CodInstituicao foreign key (cd_instituicao)
        references Instituicao (cd_instituicao),
    constraint Check_sgCurso
        check (sg_curso = 'ADS' or
                sg_curso = 'GE' or
                sg_curso = 'GP' or
                sg_curso = 'LOG' or
                sg_curso = 'SI'),
    constraint Check_nomeCurso
        check (nm_curso = 'Análise e Desenvolvimento de Sistemas' or
                nm_curso = 'Gestão Empresarial' or
                nm_curso = 'Gestão Portuária' or
                nm_curso = 'Logística' or
                nm_curso = 'Sistemas para Internet')
);