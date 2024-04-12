package com.br.M1S2.miniprojeto02modulo01.controller;

import com.br.M1S2.miniprojeto02modulo01.entity.ProfessorEntity;
import com.br.M1S2.miniprojeto02modulo01.service.ProfessorService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("professores")
public class ProfessorController {

    private static final Logger logger = LoggerFactory.getLogger(AlunoController.class);
    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<ProfessorEntity>> listarProfessores() {
        List<ProfessorEntity> professores = professorService.listarProfessores();
        logger.debug("Total de professores encontrados: {}", professores.size());
        return ResponseEntity.status(HttpStatus.OK).body(professores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorEntity> obterProfessorPorId(@PathVariable Long id) {
        ProfessorEntity professor = professorService.obterProfessorPorId(id);
        logger.debug("Professor encontrado: {}", id, professor);
        return ResponseEntity.status(HttpStatus.OK).body(professor);
    }

    @PostMapping
    public ResponseEntity<ProfessorEntity> adicionarProfessor(@RequestBody ProfessorEntity professor) {
        ProfessorEntity novoProfessor = professorService.adicionarProfessor(professor);
        logger.debug("Novo professor adicionado: {}", novoProfessor);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProfessor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorEntity> atualizarProfessor(@PathVariable Long id, @RequestBody ProfessorEntity professorAtualizado) {
        ProfessorEntity professor = professorService.atualizarProfessor(id, professorAtualizado);
        logger.debug("Professor atualizado: {}", id, professor);
        return ResponseEntity.status(HttpStatus.OK).body(professor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Long id) {
        professorService.deletarProfessor(id);
        logger.debug("Professor deletado com sucesso", id);
        return ResponseEntity.noContent().build();
    }
}
