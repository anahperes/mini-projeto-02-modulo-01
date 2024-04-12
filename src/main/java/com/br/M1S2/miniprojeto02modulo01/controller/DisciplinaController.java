package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entity.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.service.DisciplinaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("disciplinas")
public class DisciplinaController {

    private final DisciplinaService disciplinaService;

    public DisciplinaController(DisciplinaService disciplinaService) {
        this.disciplinaService = disciplinaService;
    }

    @GetMapping
    public ResponseEntity<List<DisciplinaEntity>> listarDisciplinas() {
        List<DisciplinaEntity> disciplinas = disciplinaService.listarDisciplinas();
        log.debug("Total de disciplinas encontradas: {}", disciplinas.size());
        return ResponseEntity.status(HttpStatus.OK).body(disciplinas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaEntity> obterDisciplinaPorId(@PathVariable Long id) {
        DisciplinaEntity disciplina = disciplinaService.obterDisciplinaPorId(id);
        log.debug("Disciplina encontrada: {}", id, disciplina);
        return ResponseEntity.status(HttpStatus.OK).body(disciplina);
    }

    @PostMapping
    public ResponseEntity<DisciplinaEntity> adicionarDisciplina(@RequestBody DisciplinaEntity disciplina) {
        DisciplinaEntity novaDisciplina = disciplinaService.adicionarDisciplina(disciplina);
        log.debug("Nova disciplina adicionada: {}", novaDisciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaDisciplina);
    }
    @PutMapping("/{id}")
    public ResponseEntity<DisciplinaEntity> atualizarDisciplina(@PathVariable Long id, @RequestBody DisciplinaEntity disciplinaAtualizada) {
        DisciplinaEntity disciplina = disciplinaService.atualizarDisciplina(id, disciplinaAtualizada);
        log.debug("Disciplina atualizada: {}", id, disciplina);
        return ResponseEntity.status(HttpStatus.OK).body(disciplina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDisciplina(@PathVariable Long id) {
        disciplinaService.deletarDisciplina(id);
        log.debug("Disciplina deletada com sucesso", id);
        return ResponseEntity.noContent().build();
    }
}
