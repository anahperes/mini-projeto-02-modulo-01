package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entity.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.service.AlunoService;
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
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarAluno(newAluno));
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> getId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.obterAlunoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> get() {
        return ResponseEntity.status(HttpStatus.OK).body(service.listarAlunos());
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> put(@PathVariable Long id, @RequestBody AlunoEntity entity) {
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizarAluno(id, entity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) {
        service.deletarAluno(id);
        return ResponseEntity.noContent().build();
    }



}
