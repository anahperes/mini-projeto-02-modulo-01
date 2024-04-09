package com.br.M1S2.miniprojeto02modulo01.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "aluno")
public class AlunoEntity implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Date nascimento;

    @JsonIgnore
    @OneToMany(mappedBy = "aluno")
    private List<DisciplinaMatriculaEntity> matriculas;
}