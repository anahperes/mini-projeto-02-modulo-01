package com.br.M1S2.miniprojeto02modulo01.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "notas")
public class NotasEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matricula_id")
    private DisciplinaMatriculaEntiy matricula;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "professor_id")
    private ProfessorEntity professor;


    @Column(name = "nota")
    private Double nota = 0.00;

    @Column(name = "coeficiente")
    private Double coeficiente = 0.0;
}
