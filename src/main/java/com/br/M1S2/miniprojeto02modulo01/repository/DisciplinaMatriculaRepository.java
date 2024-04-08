package com.br.M1S2.miniprojeto02modulo01.repository;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaMatriculaRepository extends JpaRepository<DisciplinaMatriculaEntiy, Long> {

    @Query("SELECT dsc FROM DisciplinaMatriculaEntiy dsc WHERE dsc.disciplina.id = :idDisciplina")
    List<DisciplinaMatriculaEntiy> buscaTodasPorDisciplinaPorId(@Param("idDisciplina") Long idDisciplina);
}
