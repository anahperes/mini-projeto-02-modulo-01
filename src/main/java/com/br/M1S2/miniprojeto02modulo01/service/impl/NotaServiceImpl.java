package com.br.M1S2.miniprojeto02modulo01.service.impl;
import com.br.M1S2.miniprojeto02modulo01.entity.NotaEntity;
import com.br.M1S2.miniprojeto02modulo01.repository.NotaRepository;
import com.br.M1S2.miniprojeto02modulo01.service.NotaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotaServiceImpl implements NotaService {

    private final NotaRepository repository;
    public NotaServiceImpl(NotaRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<NotaEntity> getAll() {
        List<NotaEntity> lista = repository.findAll();
        return lista;
    }

    @Override
    public NotaEntity getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public NotaEntity update(Long id, NotaEntity nota) {
        return repository.save(nota);
    }

    @Override
    public NotaEntity cadastrar(NotaEntity novaNota) {
        return repository.save(novaNota);
    }

    @Override
    public void dell(Long id) {
        NotaEntity nota = getById(id);
        repository.delete(nota);
    }


}
