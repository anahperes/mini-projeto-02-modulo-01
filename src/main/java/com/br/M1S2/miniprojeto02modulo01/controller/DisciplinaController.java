package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.services.DisciplinaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;
    private static final Logger logger = LoggerFactory.getLogger(DisciplinaController.class);
    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<DisciplinaEntity> post(@RequestBody DisciplinaEntity novaDisciplina) {
        logger.info("Cadastrando disciplina..");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(novaDisciplina));
    }

    @GetMapping("{id}")
    public ResponseEntity<DisciplinaEntity> getId(@PathVariable Long id) {
        logger.info("Buscando disciplina por ID {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<DisciplinaEntity>> get() {
        logger.info("Buscando todas as disciplinas cadastradas");
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PutMapping("{id}")
    public ResponseEntity<DisciplinaEntity> put(@PathVariable Long id, @RequestBody DisciplinaEntity entity) {
        logger.info("Atualizando nome da disciplina");
        return ResponseEntity.status(HttpStatus.OK).body(service.update(id, entity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) {
        service.dell(id);
        logger.info("Disciplina removida");
        return ResponseEntity.noContent().build();
    }

}
