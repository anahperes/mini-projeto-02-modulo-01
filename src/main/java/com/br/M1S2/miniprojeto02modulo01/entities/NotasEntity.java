package com.br.M1S2.miniprojeto02modulo01.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notas")
public class NotasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private DisciplinaMatriculaEntiy matricula;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;


    @Column(name = "nota")
    private Double nota = 0.00;

    @Column(name = "coeficiente")
    private Integer coeficiente = 0;
}
