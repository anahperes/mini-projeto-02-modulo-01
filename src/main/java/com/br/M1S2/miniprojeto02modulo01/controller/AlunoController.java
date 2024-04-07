package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.services.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService service;
    public AlunoController(AlunoService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<AlunoEntity> post(@RequestBody AlunoEntity newAluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(newAluno));
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> get() {
        var all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> put(@PathVariable Long id, @RequestBody AlunoEntity entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) {
        service.dell(id);
        return ResponseEntity.noContent().build();
    }

}
