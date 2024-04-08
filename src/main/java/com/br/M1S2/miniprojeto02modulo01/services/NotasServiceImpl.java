package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.DTOrequest.DTOnotas;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;
import com.br.M1S2.miniprojeto02modulo01.entities.NotasEntity;
import com.br.M1S2.miniprojeto02modulo01.repository.MatricularRepository;
import com.br.M1S2.miniprojeto02modulo01.repository.NotasRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotasServiceImpl implements NotasService {

    private final NotasRepository repository;
    private final MatricularRepository matricularRepository;
    public NotasServiceImpl(NotasRepository repository, MatricularRepository matricularRepository) {
        this.repository = repository;
        this.matricularRepository = matricularRepository;
    }

    @Override
    public NotasEntity cadastrar(DTOnotas novaNota) {
        NotasEntity nova = new NotasEntity();
        nova.setNota(novaNota.getNota());
        nova.setCoeficiente(novaNota.getCoeficiente());
        nova.setMatricula(matricularRepository.getById(novaNota.getMatricula_id()));

        return repository.save(nova);
    }

    @Override
    public void dell(Long id) {
        NotasEntity nota = repository.getById(id);
        repository.delete(nota);
    }

    @Override
    public List<NotasEntity> getById(Long id) {
        DisciplinaMatriculaEntiy matricula = matricularRepository.getById(id);
        List<NotasEntity> list = repository.findAll().stream().filter(x -> x.getMatricula()
                .getId().equals(matricula.getId())).collect(Collectors.toList());
        return list;
    }

    //Não está no card
    @Override
    public List<NotasEntity> getAll() {
        return repository.findAll();
    }

}
