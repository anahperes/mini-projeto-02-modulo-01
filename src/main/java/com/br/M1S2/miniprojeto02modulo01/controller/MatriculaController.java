package com.br.M1S2.miniprojeto02modulo01.controller;

import com.br.M1S2.miniprojeto02modulo01.dto.MatriculaDTO;
import com.br.M1S2.miniprojeto02modulo01.dto.MediaGeralAlunoDTO;
import com.br.M1S2.miniprojeto02modulo01.entity.DisciplinaMatriculaEntity;
import com.br.M1S2.miniprojeto02modulo01.service.DisciplinaMatriculaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("matriculas")
public class MatriculaController {

    private final DisciplinaMatriculaService disciplinaMatriculaService;

    @PostMapping
    public ResponseEntity<DisciplinaMatriculaEntity> matricularAluno(@RequestBody MatriculaDTO matriculaDto) {
        Long idAluno = matriculaDto.getIdAluno();
        Long idDisciplina = matriculaDto.getIdDisciplina();
        DisciplinaMatriculaEntity matricula = disciplinaMatriculaService.matricularAluno(idAluno, idDisciplina);

        return ResponseEntity.status(HttpStatus.CREATED).body(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMatricula(@PathVariable Long id) {
        disciplinaMatriculaService.deletarMatricula(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaMatriculaEntity> obterMatriculaPorId(@PathVariable Long id) {
        DisciplinaMatriculaEntity matricula = disciplinaMatriculaService.buscarMatriculaPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(matricula);
    }

    @GetMapping("/aluno/{idAluno}")
    public ResponseEntity<List<DisciplinaMatriculaEntity>> obterMatriculasPorAluno(@PathVariable Long idAluno) {
        List<DisciplinaMatriculaEntity> matriculas = disciplinaMatriculaService.buscarMatriculasPorAluno(idAluno);
        return ResponseEntity.status(HttpStatus.OK).body(matriculas);
    }

    @GetMapping("/disciplina/{idDisciplina}")
    public ResponseEntity<List<DisciplinaMatriculaEntity>> obterMatriculasPorDisciplina(@PathVariable Long idDisciplina) {
        List<DisciplinaMatriculaEntity> matriculas = disciplinaMatriculaService.buscarMatriculasPorDisciplina(idDisciplina);
        return ResponseEntity.status(HttpStatus.OK).body(matriculas);
    }

    @GetMapping("/aluno/{id}/media-geral")
    public ResponseEntity<MediaGeralAlunoDTO> calcularMediaGeralDoAluno(@PathVariable Long id) {
        MediaGeralAlunoDTO mediaGeralAlunoDTO = disciplinaMatriculaService.calcularMediaGeralDoAluno(id);
        return ResponseEntity.status(HttpStatus.OK).body(mediaGeralAlunoDTO);
    }
}