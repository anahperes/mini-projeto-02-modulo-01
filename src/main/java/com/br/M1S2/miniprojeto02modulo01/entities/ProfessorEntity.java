package com.br.M1S2.miniprojeto02modulo01.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "professor")
public class ProfessorEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 150)
    private String nome;

    @JsonIgnore
    @OneToMany(mappedBy = "professor")
    private List<DisciplinaEntity> disciplinas;

}
