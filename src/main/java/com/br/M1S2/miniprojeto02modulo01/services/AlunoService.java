package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import java.util.List;

public interface AlunoService {
    public List<AlunoEntity> getAll();

    public AlunoEntity getById(Long id);

    public AlunoEntity update(Long id, AlunoEntity caderno);

    public AlunoEntity cadastrar(AlunoEntity newAluno);

    void dell(Long id);
}
