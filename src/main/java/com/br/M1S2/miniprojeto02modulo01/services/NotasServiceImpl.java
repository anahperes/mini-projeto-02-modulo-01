package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.NotasEntity;
import com.br.M1S2.miniprojeto02modulo01.repository.NotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasServiceImpl implements NotasService {

    private final NotasRepository repository;
    public NotasServiceImpl(NotasRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<NotasEntity> getAll() {
        List<NotasEntity> lista = repository.findAll();
        return lista;
    }

    @Override
    public NotasEntity getById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public NotasEntity update(Long id, NotasEntity nota) {
        return repository.save(nota);
    }

    @Override
    public NotasEntity cadastrar(NotasEntity novaNota) {
        return repository.save(novaNota);
    }

    @Override
    public void dell(Long id) {
        NotasEntity nota = getById(id);
        repository.delete(nota);
    }


}
