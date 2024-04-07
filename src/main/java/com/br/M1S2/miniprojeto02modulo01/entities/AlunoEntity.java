package com.br.M1S2.miniprojeto02modulo01.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "alunos")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Date nascimento;

    @OneToMany(mappedBy = "aluno")
    private List<DisciplinaMatriculaEntiy> disciplinas;
}