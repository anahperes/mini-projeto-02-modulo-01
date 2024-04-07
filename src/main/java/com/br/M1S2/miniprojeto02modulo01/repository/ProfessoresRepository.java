package com.br.M1S2.miniprojeto02modulo01.repository;
import com.br.M1S2.miniprojeto02modulo01.entities.ProfessoresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessoresRepository extends JpaRepository<ProfessoresEntity, Long> {
}
