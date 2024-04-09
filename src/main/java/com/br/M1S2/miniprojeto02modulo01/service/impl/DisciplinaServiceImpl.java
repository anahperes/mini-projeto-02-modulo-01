package com.br.M1S2.miniprojeto02modulo01.service.impl;
import com.br.M1S2.miniprojeto02modulo01.entity.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.exception.NotFoundException;
import com.br.M1S2.miniprojeto02modulo01.repository.DisciplinaRepository;
import com.br.M1S2.miniprojeto02modulo01.service.DisciplinaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {


    private static final Logger logger = LoggerFactory.getLogger(DisciplinaServiceImpl.class);
    private final DisciplinaRepository disciplinaRepository;
    public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public DisciplinaEntity obterDisciplinaPorId(Long id) {
        logger.info("Obtendo disciplina por ID: {}", id);
        Optional<DisciplinaEntity> disciplinaOptional = disciplinaRepository.findById(id);
        return disciplinaOptional.orElseThrow(() -> {
            logger.warn("Disciplina não encontrada com o ID: {}", id);
            return new NotFoundException("Disciplina não encontrada com o ID: " + id);
        });
    }

    @Override
    public DisciplinaEntity adicionarDisciplina(DisciplinaEntity disciplina) {
        logger.info("Adicionando nova disciplina: {}", disciplina);
        return disciplinaRepository.save(disciplina);
    }

    @Override
    public List<DisciplinaEntity> listarDisciplinas() {
        logger.info("Listando todas as disciplinas");
        return disciplinaRepository.findAll();
    }

    @Override
    public DisciplinaEntity atualizarDisciplina(Long id, DisciplinaEntity disciplinaAtualizada) {
        logger.info("Atualizando disciplina com o ID: {}", id);
        verificarExistenciaDisciplina(id);
        disciplinaAtualizada.setId(id);
        return disciplinaRepository.save(disciplinaAtualizada);
    }

    @Override
    public void deletarDisciplina(Long id) {
        logger.info("Deletando disciplina com o ID: {}", id);
        verificarExistenciaDisciplina(id);
        disciplinaRepository.deleteById(id);
    }

    private void verificarExistenciaDisciplina(Long id) {
        if (!disciplinaRepository.existsById(id)) {
            logger.warn("Disciplina não encontrada com o ID: {}", id);
            throw new NotFoundException("Disciplina não encontrada com o ID: " + id);
        }
    }
}
