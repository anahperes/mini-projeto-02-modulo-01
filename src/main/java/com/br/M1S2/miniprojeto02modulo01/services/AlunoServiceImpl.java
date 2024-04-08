package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.exception.NotFoundException;
import com.br.M1S2.miniprojeto02modulo01.repository.AlunoRepository;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
public class AlunoServiceImpl implements AlunoService{

    //Traz o repositório e reclama construtor
    private final AlunoRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(AlunoServiceImpl.class);
    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }

    //Métodos implementados quando implementado "AlunoService"
    @Override
    public List<AlunoEntity> getAll() {
        logger.info("Listando todos os Alunos");
        return repository.findAll();
    }

    @Override
    public AlunoEntity getById(Long id) {
        logger.info("Obtendo Aluno por ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Aluno não encontrado com ID: {}", id);
            throw new NotFoundException("Aluno não encontrado com ID: " + id);
        }
        return repository.findById(id).get();
    }

    @Override
    public AlunoEntity update(Long id, AlunoEntity alunoUpdate) {
        logger.info("Atualizando Aluno com o ID: {}", id);
        AlunoEntity entity = repository.findById(id).get();

        if (!repository.existsById(id)) {
            logger.warn("Aluno não encontrado com o ID: {}", id);
            throw new NotFoundException("Aluno não encontrado com o ID: " + id);
        }

        entity.setNome(alunoUpdate.getNome());
        entity.setNascimento(alunoUpdate.getNascimento());
        logger.info("Aluno atualizado - ID: {}", id);
        return entity;
    }

    @Override
    public AlunoEntity cadastrar(AlunoEntity newAluno) {
        logger.info("Cadastrando novo Aluno: {}", newAluno);
        return repository.save(newAluno);
    }

    @Override
    public void dell(Long id) {
        AlunoEntity aluno = getById(id);
        logger.info("Deletando Aluno com o ID: {}", id);
        if (!repository.existsById(id)) {
            logger.warn("Aluno não encontrado com o ID: {}", id);
            throw new NotFoundException("Aluno não encontrado com o ID: " + id);
        }
        repository.delete(aluno);
        logger.info("Aluno deletado - ID: {}", id);
    }
}
