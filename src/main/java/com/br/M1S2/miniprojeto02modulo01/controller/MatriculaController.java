package com.br.M1S2.miniprojeto02modulo01.controller;

import com.br.M1S2.miniprojeto02modulo01.dto.MatriculaDTO;
import com.br.M1S2.miniprojeto02modulo01.dto.MediaGeralAlunoDTO;
import com.br.M1S2.miniprojeto02modulo01.entity.DisciplinaMatriculaEntity;
import com.br.M1S2.miniprojeto02modulo01.service.DisciplinaMatriculaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
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

        log.debug("Matrícula efetuada na disciplina: {}", idDisciplina);
        return ResponseEntity.status(HttpStatus.CREATED).body(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarMatricula(@PathVariable Long id) {
        disciplinaMatriculaService.deletarMatricula(id);
        log.debug("Matrícula deletada: {}", id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DisciplinaMatriculaEntity> obterMatriculaPorId(@PathVariable Long id) {
        DisciplinaMatriculaEntity matricula = disciplinaMatriculaService.buscarMatriculaPorId(id);
        log.debug("Matrícula encontrada no id: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(matricula);
    }

    @GetMapping("/aluno/{idAluno}")
    public ResponseEntity<List<DisciplinaMatriculaEntity>> obterMatriculasPorAluno(@PathVariable Long idAluno) {
        List<DisciplinaMatriculaEntity> matriculas = disciplinaMatriculaService.buscarMatriculasPorAluno(idAluno);
        log.debug("Matrícula encontrada do aluno: {}", idAluno);
        return ResponseEntity.status(HttpStatus.OK).body(matriculas);
    }

    @GetMapping("/disciplina/{idDisciplina}")
    public ResponseEntity<List<DisciplinaMatriculaEntity>> obterMatriculasPorDisciplina(@PathVariable Long idDisciplina) {
        List<DisciplinaMatriculaEntity> matriculas = disciplinaMatriculaService.buscarMatriculasPorDisciplina(idDisciplina);
        log.debug("Matrícula encontrada na disciplina: {}", idDisciplina);
        return ResponseEntity.status(HttpStatus.OK).body(matriculas);
    }

    @GetMapping("/aluno/{id}/media-geral")
    public ResponseEntity<MediaGeralAlunoDTO> calcularMediaGeralDoAluno(@PathVariable Long id) {
        MediaGeralAlunoDTO mediaGeralAlunoDTO = disciplinaMatriculaService.calcularMediaGeralDoAluno(id);
        log.debug("Média geral do aluno da matrícula: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(mediaGeralAlunoDTO);
    }
}