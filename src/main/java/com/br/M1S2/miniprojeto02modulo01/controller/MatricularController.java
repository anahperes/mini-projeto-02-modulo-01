package com.br.M1S2.miniprojeto02modulo01.controller;

import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;
import com.br.M1S2.miniprojeto02modulo01.services.AlunoService;
import com.br.M1S2.miniprojeto02modulo01.services.DisciplinaService;
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






    //Retorna uma matrícula por ID
    @GetMapping("{id}")
    public ResponseEntity<DisciplinaMatriculaEntiy> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    //Retorna as Matrículas de um Aluno (todas)
    @GetMapping
    public ResponseEntity<List<DisciplinaMatriculaEntiy>> get() {
        var all = service.getAll();
        return ResponseEntity.ok(all);
    }



    //Realiza uma Matrícula - Recebe Aluno_id e Disciplina_ID
    @PutMapping("aluno/{id}")
    public ResponseEntity<DisciplinaMatriculaEntiy> put(@PathVariable Long id, @RequestBody DisciplinaMatriculaEntiy entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }



    //Recebe um ID de matrícula a ser excluída - Valida se existe notas
    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) {
        service.dell(id);
        return ResponseEntity.noContent().build();
    }

}
