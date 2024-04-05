package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public interface AlunoService {
    public List<AlunoEntity> getAll();

    public AlunoEntity getById(Long id);

    public AlunoEntity update(Long id, AlunoEntity caderno);

    void dell(Long id);
}
