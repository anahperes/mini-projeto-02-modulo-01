package com.br.M1S2.miniprojeto02modulo01.entities.DTOrequest;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class DTOrequest {
    private Long aluno_id;
    private Long disciplina_id;
}
