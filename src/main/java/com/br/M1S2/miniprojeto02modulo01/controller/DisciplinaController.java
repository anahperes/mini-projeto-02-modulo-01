package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.services.DisciplinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {

    private final DisciplinaService service;
    public DisciplinaController(DisciplinaService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<DisciplinaEntity> post(@RequestBody DisciplinaEntity novaDisciplina) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(novaDisciplina));
    }

    @GetMapping("{id}")
    public ResponseEntity<DisciplinaEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<DisciplinaEntity>> get() {
        var all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("{id}")
    public ResponseEntity<DisciplinaEntity> put(@PathVariable Long id, @RequestBody DisciplinaEntity entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) {
        service.dell(id);
        return ResponseEntity.noContent().build();
    }

}
