package com.br.M1S2.miniprojeto02modulo01.services;

import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.exception.NotFoundException;
import com.br.M1S2.miniprojeto02modulo01.repository.AlunoRepository;
import org.antlr.v4.runtime.misc.LogManager;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService {

    //Traz o repositório e reclama construtor
    private final AlunoRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(AlunoServiceImpl.class);

    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    //Métodos implementados quando implementado "AlunoService"
    @Override
    public List<AlunoEntity> listarAlunos() {
        logger.info("Listando todos os Alunos");
        return repository.findAll();
    }

    @Override
    public AlunoEntity obterAlunoPorId(Long id) {
        logger.info("Obtendo Aluno por ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Aluno não encontrado com ID: {}", id);
            throw new NotFoundException("Aluno não encontrado com ID: " + id);
        }
        return repository.findById(id).get();
    }

    @Override
    public AlunoEntity atualizarAluno(Long id, AlunoEntity alunoAtualizado) {
        logger.info("Atualizando aluno com o ID: {}", id);
        verificarExistenciaAluno(id);
        alunoAtualizado.setId(id);
        return repository.save(alunoAtualizado);
    }

    @Override
    public AlunoEntity adicionarAluno(AlunoEntity newAluno) {
        logger.info("Cadastrando novo Aluno: {}", newAluno);
        return repository.save(newAluno);
    }

    @Override
    public void deletarAluno(Long id) {
        AlunoEntity aluno = obterAlunoPorId(id);
        logger.info("Deletando Aluno com o ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Aluno não encontrado com o ID: {}", id);
            throw new NotFoundException("Aluno não encontrado com o ID: " + id);
        }
        repository.delete(aluno);
        logger.info("Aluno deletado - ID: {}", id);
    }

    private void verificarExistenciaAluno(Long id) {
        if (!repository.existsById(id)) {
            logger.warn("Aluno não encontrado com o ID: {}", id);
            throw new NotFoundException("Aluno não encontrado com o ID:" + id);
        }
    }
}

