package com.br.M1S2.miniprojeto02modulo01.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    //@JsonIgnore
    @OneToMany(mappedBy = "professor")
    @JsonManagedReference
    private List<DisciplinaEntity> disciplinas;

    // Construtor que aceita um argumento do tipo int para o ID do professor
    public ProfessorEntity(int id) {
        this.id = (long) id;
    }

    public ProfessorEntity() {

    }

    @Override
    public String toString() {
        return "ProfessorEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }

}
