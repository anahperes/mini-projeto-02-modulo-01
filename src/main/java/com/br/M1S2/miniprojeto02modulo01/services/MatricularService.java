package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;

import java.util.List;

public interface MatricularService {
    public List<DisciplinaEntity> getAll();

    public DisciplinaEntity getById(Long id);

    public DisciplinaEntity update(Long id, DisciplinaEntity disciplina);

    void dell(Long id);
}
