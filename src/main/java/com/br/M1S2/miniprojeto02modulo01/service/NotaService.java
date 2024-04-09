package com.br.M1S2.miniprojeto02modulo01.service;
import com.br.M1S2.miniprojeto02modulo01.entity.NotaEntity;
import java.util.List;

public interface NotaService {
    NotaEntity adicionarNota(NotaEntity novaNota);
    List<NotaEntity> notasPorMatricula(Long idMatricula);
    void excluirNotaPorId(Long idNota);
}
