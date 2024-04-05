package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.repository.DisciplinaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscilplinaServiceImpl implements DisciplinaService {

    private final DisciplinaRepository repository;
    public DiscilplinaServiceImpl(DisciplinaRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<DisciplinaEntity> getAll() {
        List<DisciplinaEntity> lista = repository.findAll();
        return lista;
    }

    @Override
    public DisciplinaEntity getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public DisciplinaEntity update(Long id, DisciplinaEntity disciplina) {
        return repository.save(disciplina);
    }

    @Override
    public void dell(Long id) {
        DisciplinaEntity disciplina = getById(id);
        repository.delete(disciplina);
    }
}
