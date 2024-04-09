package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import java.util.List;

public interface AlunoService {
    List<AlunoEntity> listarAlunos();
    AlunoEntity obterAlunoPorId(Long id);
    AlunoEntity adicionarAluno(AlunoEntity aluno);
    AlunoEntity atualizarAluno(Long id, AlunoEntity alunoAtualizado);
    void deletarAluno(Long id);



}
