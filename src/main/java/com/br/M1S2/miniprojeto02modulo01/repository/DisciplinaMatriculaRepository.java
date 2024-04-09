package com.br.M1S2.miniprojeto02modulo01.repository;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaMatriculaRepository extends JpaRepository<DisciplinaMatriculaEntity, Long> {

    @Query("SELECT dsc FROM DisciplinaMatriculaEntity dsc WHERE dsc.disciplina.id = :idDisciplina")
    List<DisciplinaMatriculaEntity> buscaTodasPorDisciplinaPorId(@Param("idDisciplina") Long idDisciplina);

}
