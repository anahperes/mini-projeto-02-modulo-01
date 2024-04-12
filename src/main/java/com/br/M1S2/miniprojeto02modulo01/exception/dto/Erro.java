package com.br.M1S2.miniprojeto02modulo01.exception.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Erro {
    private String codigo;
    private String mensagem;
}
