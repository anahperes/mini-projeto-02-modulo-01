package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entity.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.entity.ProfessorEntity;
import com.br.M1S2.miniprojeto02modulo01.service.AlunoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("alunos")
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoEntity> adicionarAluno(@RequestBody AlunoEntity newAluno) {
        log.debug("Aluno adicionado: {}", newAluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.adicionarAluno(newAluno));
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> obterAlunoPorId(@PathVariable Long id) {
        log.debug("Aluno encontrado com id: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.obterAlunoPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> listarAlunos() {
        List<AlunoEntity> alunos = alunoService.listarAlunos();
        log.debug("Total de alunos encontrados: {}", alunos.size());
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.listarAlunos());
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> atualizarAluno(@PathVariable Long id, @RequestBody AlunoEntity entity) {
        AlunoEntity alunos = alunoService.atualizarAluno(id, entity);
        log.debug("Aluno atualizado: {}", alunos);
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.atualizarAluno(id, entity));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        alunoService.deletarAluno(id);
        log.debug("Aluno deletado: {}", id);
        return ResponseEntity.noContent().build();
    }



}
