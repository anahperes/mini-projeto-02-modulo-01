package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.exception.NotFoundException;
import com.br.M1S2.miniprojeto02modulo01.repository.DisciplinaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscilplinaServiceImpl implements DisciplinaService {

    private final DisciplinaRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(DiscilplinaServiceImpl.class);
    public DiscilplinaServiceImpl(DisciplinaRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<DisciplinaEntity> getAll() {
        logger.info("Listando todas as disciplinas");
        return repository.findAll();
    }

    @Override
    public DisciplinaEntity getById(Long id) {
        logger.info("Obtendo disciplina por ID: {}", id);

        if (!repository.existsById(id)) {
            logger.warn("Disciplina não encontrada com ID: {}", id);
            throw new NotFoundException("Disciplina não encontrada com ID: " + id);
        }

        return repository.findById(id).get();
    }

    @Override
    public DisciplinaEntity update(Long id, DisciplinaEntity disciplina) {
        logger.info("Atualizando nome da disciplina: ID {}", id);
        DisciplinaEntity entity = repository.findById(id).get();

        if (!repository.existsById(id)) {
            logger.warn("Disciplina não encontrada - ID: {}", id);
            throw new NotFoundException("Disciplina não encontrada - ID: " + id);
        }

        entity.setNome(disciplina.getNome());
        logger.info("Disciplina atualizada - ID: {}", id);
        return disciplina;
    }

    @Override
    public DisciplinaEntity cadastrar(DisciplinaEntity novaDisciplina) {
        logger.info("Cadastrando nova disciplina: {}", novaDisciplina);
        return repository.save(novaDisciplina);
    }

    @Override
    public void dell(Long id) {
        DisciplinaEntity disciplina = getById(id);
        repository.delete(disciplina);
        logger.info("Disciplina deletada - ID: {}", id);
    }
}
