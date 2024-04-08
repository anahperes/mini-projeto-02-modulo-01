package com.br.M1S2.miniprojeto02modulo01.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_nascimento")
    private Date nascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<DisciplinaMatriculaEntiy> disciplinas;
}