package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;

import java.util.List;

public interface MatricularService {

    public DisciplinaMatriculaEntiy getById(Long id);

    public List<DisciplinaMatriculaEntiy> getMatriculasByAlunoId(Long id);

    public DisciplinaMatriculaEntiy matricular(DisciplinaMatriculaEntiy matricula);

    void dell(Long id) throws Exception;
}
