package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DisciplinaService {
    public List<DisciplinaEntity> getAll();

    public DisciplinaEntity getById(Long id);

    public DisciplinaEntity update(Long id, DisciplinaEntity disciplina);

    void dell(Long id);
}
