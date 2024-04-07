package com.br.M1S2.miniprojeto02modulo01.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "professores")
public class ProfessoresEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(length = 150)
    private String nome;

//    @JsonIgnore
//    @OneToMany(mappedBy = "professor")
//    private List<DisciplinaEntity> disciplinas;
}
