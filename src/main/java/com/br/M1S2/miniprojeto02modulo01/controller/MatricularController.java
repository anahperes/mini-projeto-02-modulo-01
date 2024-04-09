package com.br.M1S2.miniprojeto02modulo01.controller;
import com.br.M1S2.miniprojeto02modulo01.entities.DTOrequest.DTOrequest;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntity;
import com.br.M1S2.miniprojeto02modulo01.services.MatricularService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("matricular")
public class MatricularController {

    private final MatricularService service;
    private static final Logger logger = LoggerFactory.getLogger(MatricularController.class);
    public MatricularController(MatricularService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<DisciplinaMatriculaEntity> post(@RequestBody DTOrequest request) {
        logger.info("Realizando matricula..");
        return ResponseEntity.status(HttpStatus.CREATED).body(service.matricular(request));
    }

    //Recebe um ID de matrícula a ser excluída - Valida se existe notas
    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) throws Exception {
        logger.info("Excluindo matricula de ID: {}", id);
        service.dell(id);
        return ResponseEntity.noContent().build();
    }

    //Retorna uma matrícula por ID
    @GetMapping("{id}")
    public ResponseEntity<DisciplinaMatriculaEntity> getId(@PathVariable Long id) {
        logger.warn("Buscando matricula por ID: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getById(id));
    }

    //Retorna as Matrículas de um Aluno (todas)
    @GetMapping("/alunos/{id}")
    public ResponseEntity<List<DisciplinaMatriculaEntity>> getMatriculasAluno(@PathVariable Long id) {
        logger.warn("Buscando matriculas do aluno ID {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getMatriculasByAlunoId(id));
    }

    //Lista todas as disciplinas de uma matrícula(ID)
    @GetMapping("/disciplinas/{id}")
    public ResponseEntity<List<DisciplinaMatriculaEntity>> get(@PathVariable Long id) {
        logger.warn("Buscando todas as matriculas da disciplina ID {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(service.getTodasDisciplinas(id));
    }

}
