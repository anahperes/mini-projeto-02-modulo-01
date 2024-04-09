package com.br.M1S2.miniprojeto02modulo01.service;
import com.br.M1S2.miniprojeto02modulo01.entity.NotaEntity;
import java.util.List;

public interface NotaService {
    public List<NotaEntity> getAll();

    public NotaEntity getById(Long id);

    public NotaEntity update(Long id, NotaEntity nota);

    public NotaEntity cadastrar(NotaEntity novaNota);



    void dell(Long id);
}
