package com.br.M1S2.miniprojeto02modulo01.entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "disciplinas")
public class DisciplinaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ig;

    private String nome;

    //@ManyToOne
    //@JoinColumn(name = "professor_id")
    //private ProfessorEntity professorEntity;

}