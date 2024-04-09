package com.br.M1S2.miniprojeto02modulo01.service;

import com.br.M1S2.miniprojeto02modulo01.entity.ProfessorEntity;

import java.util.List;

public interface ProfessorService {
    List<ProfessorEntity> listarProfessores();
    ProfessorEntity obterProfessorPorId(Long id);
    ProfessorEntity adicionarProfessor(ProfessorEntity professor);
    ProfessorEntity atualizarProfessor(Long id, ProfessorEntity professorAtualizado);
    void deletarProfessor(Long id);
}
