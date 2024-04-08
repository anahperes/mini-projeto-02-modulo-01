package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DTOrequest.DTOnotas;
import com.br.M1S2.miniprojeto02modulo01.entities.NotasEntity;

import java.util.List;

public interface NotasService {

    public List<NotasEntity> getById(Long id);

    public List<NotasEntity> getAll();

    public NotasEntity cadastrar(DTOnotas novaNota);

    void dell(Long id);
}
