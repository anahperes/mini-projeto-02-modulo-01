package com.br.M1S2.miniprojeto02modulo01.entities;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "notas")
public class NotasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matricula_id")
    private DisciplinaMatriculaEntiy matricula;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessoresEntity professor;


    @Column(name = "nota")
    private Double nota = 0.00;

    @Column(name = "coeficiente")
    private Integer coeficiente = 0;
}
