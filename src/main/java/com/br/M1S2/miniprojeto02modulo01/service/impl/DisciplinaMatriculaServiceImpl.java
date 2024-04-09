package com.br.M1S2.miniprojeto02modulo01.service.impl;

import com.br.M1S2.miniprojeto02modulo01.entity.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.entity.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.entity.DisciplinaMatriculaEntity;
import com.br.M1S2.miniprojeto02modulo01.exception.NotFoundException;
import com.br.M1S2.miniprojeto02modulo01.repository.DisciplinaMatriculaRepository;
import com.br.M1S2.miniprojeto02modulo01.service.AlunoService;
import com.br.M1S2.miniprojeto02modulo01.service.DisciplinaMatriculaService;
import com.br.M1S2.miniprojeto02modulo01.service.DisciplinaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * Implementação do serviço de matrícula em disciplinas.
 */

//@Slf4j
@RequiredArgsConstructor
@Service
public class DisciplinaMatriculaServiceImpl implements DisciplinaMatriculaService {
    private final DisciplinaMatriculaRepository matriculaRepository;
    private final AlunoService alunoService;
    private final DisciplinaService disciplinaService;

    @Override
    public DisciplinaMatriculaEntity matricularAluno(Long idAluno, Long idDisciplina) {
        AlunoEntity aluno = alunoService.obterAlunoPorId(idAluno);
        DisciplinaEntity disciplina = disciplinaService.obterDisciplinaPorId(idDisciplina);

        // Matricular aluno na disciplina
        DisciplinaMatriculaEntity matricula = new DisciplinaMatriculaEntity();
        matricula.setAluno(aluno);
        matricula.setDisciplina(disciplina);

        return matriculaRepository.save(matricula);
    }

    @Override
    public void deletarMatricula(Long id) {
        // Verificar se notas já foram lançadas para a matrícula com o ID especificado
        DisciplinaMatriculaEntity matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Matrícula não encontrada com o ID: " + id));

        // Verificar se a média final da matrícula é diferente de zero (indicando notas já lançadas)
        if (matricula.getMediaFinal().compareTo(BigDecimal.ZERO) != 0) {
            throw new NotFoundException("Notas já lançadas para a matrícula com o ID: " + id);
        }

        // Se não houver notas lançadas, deletar a matrícula
        matriculaRepository.deleteById(id);
    }

    @Override
    public DisciplinaMatriculaEntity buscarMatriculaPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public List<DisciplinaMatriculaEntity> buscarMatriculasPorAluno(Long idAluno) {
        AlunoEntity aluno = alunoService.obterAlunoPorId(idAluno);
        return matriculaRepository.findByAluno(aluno);
    }

    @Override
    public List<DisciplinaMatriculaEntity> buscarMatriculasPorDisciplina(Long idDisciplina) {
        DisciplinaEntity disciplina = disciplinaService.obterDisciplinaPorId(idDisciplina);
        return matriculaRepository.findByDisciplina(disciplina);
    }
}