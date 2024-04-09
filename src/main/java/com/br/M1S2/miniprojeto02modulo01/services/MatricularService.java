package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DTOrequest.DTOrequest;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntity;
import java.util.List;

public interface MatricularService {

    public DisciplinaMatriculaEntity getById(Long id);

    public List<DisciplinaMatriculaEntity> getMatriculasByAlunoId(Long id);

    public List<DisciplinaMatriculaEntity> getTodasDisciplinas(Long id);

    public DisciplinaMatriculaEntity matricular(DTOrequest entity);

    void dell(Long id) throws Exception;
}
