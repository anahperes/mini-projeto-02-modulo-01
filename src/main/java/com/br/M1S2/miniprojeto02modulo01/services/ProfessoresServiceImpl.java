package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.ProfessoresEntity;
import com.br.M1S2.miniprojeto02modulo01.repository.ProfessoresRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProfessoresServiceImpl implements ProfessoresService{
    private final ProfessoresRepository repository;

    public ProfessoresServiceImpl(ProfessoresRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ProfessoresEntity> getAll() {
        return repository.findAll();
    }

    @Override
    public ProfessoresEntity create(ProfessoresEntity professores) {
        return repository.save(professores);
    };

    @Override
    public ProfessoresEntity getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public ProfessoresEntity update(Long id, ProfessoresEntity professores) {
        return repository.save(professores);
    }

    @Override
    public void dell(Long id) {
        ProfessoresEntity professores = getById(id);
        repository.delete(professores);
    }
}
