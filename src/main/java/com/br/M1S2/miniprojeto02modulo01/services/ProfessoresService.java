package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.ProfessoresEntity;
import org.springframework.stereotype.Service;
import java.util.List;


public interface ProfessoresService {
    public List<ProfessoresEntity> getAll();

    public ProfessoresEntity create(ProfessoresEntity professores);

    public ProfessoresEntity getById(Long id);

    public ProfessoresEntity update(Long id, ProfessoresEntity professores);

    void dell(Long id);
}
