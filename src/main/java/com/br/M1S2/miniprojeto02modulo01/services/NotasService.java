package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.NotasEntity;
import java.util.List;

public interface NotasService {
    public List<NotasEntity> getAll();

    public NotasEntity getById(Long id);

    public NotasEntity update(Long id, NotasEntity nota);

    public NotasEntity cadastrar(NotasEntity novaNota);

    void dell(Long id);
}
