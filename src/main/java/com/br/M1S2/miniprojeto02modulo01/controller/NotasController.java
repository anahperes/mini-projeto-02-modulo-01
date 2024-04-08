package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.entities.DTOrequest.DTOnotas;
import com.br.M1S2.miniprojeto02modulo01.entities.NotasEntity;
import com.br.M1S2.miniprojeto02modulo01.services.AlunoService;
import com.br.M1S2.miniprojeto02modulo01.services.NotasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notas")
public class NotasController {

    private final NotasService service;
    public NotasController(NotasService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NotasEntity> post(@RequestBody DTOnotas novaNota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(novaNota));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) {
        service.dell(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("{id}")
    public ResponseEntity<List<NotasEntity>> getById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }
    @GetMapping
    public ResponseEntity<List<NotasEntity>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

}
