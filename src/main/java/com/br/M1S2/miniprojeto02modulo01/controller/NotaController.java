package com.br.M1S2.miniprojeto02modulo01.controller;


import com.br.M1S2.miniprojeto02modulo01.entity.NotaEntity;
import com.br.M1S2.miniprojeto02modulo01.service.NotaService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("notas")
public class NotaController {

    private final NotaService notaService;

    @PostMapping
    public ResponseEntity<NotaEntity> adicionarNota(@RequestBody NotaEntity notaRequest) {
        NotaEntity novaNota = notaService.adicionarNota(notaRequest);
        log.debug("Nota adicionada: {}", novaNota);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaNota);
    }

    @GetMapping("/matriculas/{id}")
    public ResponseEntity<List<NotaEntity>> listarNotas(@PathVariable Long id) {
        List<NotaEntity> notas = notaService.notasPorMatricula(id);
        log.debug("Notas encontradas: {}", notas.size());
        return ResponseEntity.status(HttpStatus.OK).body(notas);
    }

    // Em NotaController.java
    @DeleteMapping("{id}")
    public ResponseEntity<Void> excluirNota(@PathVariable Long id) {
        notaService.excluirNotaPorId(id);
        log.debug("Nota exluída: {}", id);
        return ResponseEntity.noContent().build();
    }
}
