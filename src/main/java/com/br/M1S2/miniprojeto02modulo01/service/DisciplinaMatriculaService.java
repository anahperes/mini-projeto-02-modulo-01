package com.br.M1S2.miniprojeto02modulo01.service;

import com.br.M1S2.miniprojeto02modulo01.dto.MediaGeralAlunoDTO;
import com.br.M1S2.miniprojeto02modulo01.entity.DisciplinaMatriculaEntity;

import java.util.List;

public interface DisciplinaMatriculaService {
    DisciplinaMatriculaEntity matricularAluno(Long idAluno, Long idDisciplina);
    void deletarMatricula(Long id);
    DisciplinaMatriculaEntity buscarMatriculaPorId(Long id);
    List<DisciplinaMatriculaEntity> buscarMatriculasPorAluno(Long idAluno);
    List<DisciplinaMatriculaEntity> buscarMatriculasPorDisciplina(Long idDisciplina);

    MediaGeralAlunoDTO calcularMediaGeralDoAluno(Long idAluno);
}
