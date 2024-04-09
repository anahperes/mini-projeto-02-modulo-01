package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import java.util.List;

public interface DisciplinaService {
    DisciplinaEntity obterDisciplinaPorId(Long id);
    List<DisciplinaEntity> listarDisciplinas();
    DisciplinaEntity adicionarDisciplina(DisciplinaEntity disciplina);
    DisciplinaEntity atualizarDisciplina(Long id, DisciplinaEntity atualizadoDisciplina);
    void deletarDisciplina(Long id);
}
