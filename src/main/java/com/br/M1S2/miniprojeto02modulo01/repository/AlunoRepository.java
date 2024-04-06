package com.br.M1S2.miniprojeto02modulo01.repository;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
