package com.br.M1S2.miniprojeto02modulo01.entities;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "disciplina_matricula")
public class DisciplinaMatriculaEntiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private DisciplinaEntity disciplina;


    @OneToMany(mappedBy = "matricula")
    private List<NotasEntity> notas;


    @Column(name = "data_matricula")
    private LocalDate dataMatricula = LocalDate.now();

    @Column(name = "media_final", nullable = false)
    private Double mediaFinal = 0.00;

}