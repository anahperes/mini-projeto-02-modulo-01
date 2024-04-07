package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.repository.AlunoRepository;
import java.util.List;

public class AlunoServiceImpl implements AlunoService{

    //Traz o repositório e reclama construtor
    private final AlunoRepository repository;
    public AlunoServiceImpl(AlunoRepository repository) {
        this.repository = repository;
    }


    //Métodos implementados quando implementado "AlunoService"
    @Override
    public List<AlunoEntity> getAll() {
        List<AlunoEntity> lista = repository.findAll();
        return lista;
    }

        @Override
    public AlunoEntity getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public AlunoEntity update(Long id, AlunoEntity aluno) {
        return repository.save(aluno);
    }

    @Override
    public AlunoEntity cadastrar(AlunoEntity newAluno) {
        return repository.save(newAluno);
    }

    @Override
    public void dell(Long id) {
        AlunoEntity aluno = getById(id);
        repository.delete(aluno);
    }
}
