package com.br.M1S2.miniprojeto02modulo01.repository;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatricularRepository extends JpaRepository<DisciplinaMatriculaEntiy, Long> {
}
