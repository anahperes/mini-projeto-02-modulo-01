package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DTOrequest.DTOrequest;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;
import java.util.List;

public interface MatricularService {

    public DisciplinaMatriculaEntiy getById(Long id);

    public List<DisciplinaMatriculaEntiy> getMatriculasByAlunoId(Long id);

    public List<DisciplinaMatriculaEntiy> getTodasDisciplinas(Long id);

    public DisciplinaMatriculaEntiy matricular(DTOrequest entity);

    void dell(Long id) throws Exception;
}
