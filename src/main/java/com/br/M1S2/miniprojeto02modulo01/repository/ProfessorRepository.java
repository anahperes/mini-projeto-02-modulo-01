package com.br.M1S2.miniprojeto02modulo01.repository;

import com.br.M1S2.miniprojeto02modulo01.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProfessorRepository extends JpaRepository<ProfessorEntity, Long> {
}
