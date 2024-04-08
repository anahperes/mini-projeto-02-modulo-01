package com.br.M1S2.miniprojeto02modulo01.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "disciplinas")
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;


    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;

}
