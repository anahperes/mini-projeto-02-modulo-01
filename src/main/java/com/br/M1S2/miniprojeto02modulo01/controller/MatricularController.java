package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;
import com.br.M1S2.miniprojeto02modulo01.services.MatricularService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("matricular")
public class MatricularController {

    private final MatricularService service;
    public MatricularController(MatricularService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<DisciplinaMatriculaEntiy> post(@RequestBody DisciplinaMatriculaEntiy request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.matricular(request));
    }

    //Recebe um ID de matrícula a ser excluída - Valida se existe notas
    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) throws Exception {
        service.dell(id);
        return ResponseEntity.noContent().build();
    }

    //Retorna uma matrícula por ID
    @GetMapping("{id}")
    public ResponseEntity<DisciplinaMatriculaEntiy> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    //Retorna as Matrículas de um Aluno (todas)
    @GetMapping("/alunos/{id}")
    public ResponseEntity<List<DisciplinaMatriculaEntiy>> getMatriculasAluno(@PathVariable Long id) {
        var all = service.getMatriculasByAlunoId(id);
        return ResponseEntity.ok(all);
    }

    //Lista todas as disciplinas de uma matrícula(ID)
    @GetMapping("/disciplinas/{id}")
    public ResponseEntity<List<DisciplinaMatriculaEntiy>> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getTodasDisciplinas(id));
    }

}
