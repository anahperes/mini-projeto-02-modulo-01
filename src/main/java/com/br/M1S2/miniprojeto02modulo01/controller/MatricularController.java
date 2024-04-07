package com.br.M1S2.miniprojeto02modulo01.controller;

import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.services.AlunoService;
import com.br.M1S2.miniprojeto02modulo01.services.DisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("matricular")
public class MatricularController {

    private final DisciplinaService service;
    private final AlunoService alunoService;
    public MatricularController(DisciplinaService service, AlunoService alunoService) {
        this.service = service;
        this.alunoService = alunoService;
    }


    //Retorna uma matrícula por ID
    @GetMapping("{id}")
    public ResponseEntity<DisciplinaEntity> getId(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    //Retorna as Matrículas de um Aluno (todas)
    @GetMapping
    public ResponseEntity<List<DisciplinaEntity>> get() {
        var all = service.getAll();
        return ResponseEntity.ok(all);
    }





    //Realiza uma Matrícula - Recebe Aluno_id e Disciplina_ID
    @PutMapping("aluno/{id}")
    public ResponseEntity<DisciplinaEntity> put(@PathVariable Long id, @RequestBody DisciplinaEntity entity) {
        return ResponseEntity.ok(service.update(id, entity));
    }






    //Recebe um ID de matrícula a ser excluída - Valida se existe notas
    @DeleteMapping("{id}")
    public ResponseEntity<Void> dell(@PathVariable Long id) {
        service.dell(id);
        return ResponseEntity.noContent().build();
    }

}
