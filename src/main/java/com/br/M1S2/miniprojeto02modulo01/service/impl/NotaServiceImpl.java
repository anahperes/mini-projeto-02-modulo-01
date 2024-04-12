package com.br.M1S2.miniprojeto02modulo01.service.impl;

import com.br.M1S2.miniprojeto02modulo01.entity.DisciplinaMatriculaEntity;
import com.br.M1S2.miniprojeto02modulo01.entity.NotaEntity;
import com.br.M1S2.miniprojeto02modulo01.exception.NotFoundException;
import com.br.M1S2.miniprojeto02modulo01.repository.DisciplinaMatriculaRepository;
import com.br.M1S2.miniprojeto02modulo01.repository.NotaRepository;
import com.br.M1S2.miniprojeto02modulo01.service.NotaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class   NotaServiceImpl implements NotaService {

    private static final Logger logger = LoggerFactory.getLogger(NotaServiceImpl.class);

    private final NotaRepository notaRepository;
    private final DisciplinaMatriculaRepository disciplinaMatriculaRepository;

    public NotaServiceImpl(NotaRepository notaRepository, DisciplinaMatriculaRepository disciplinaMatriculaRepository) {
        this.notaRepository = notaRepository;
        this.disciplinaMatriculaRepository = disciplinaMatriculaRepository;
    }

    @Override
    public NotaEntity adicionarNota(NotaEntity novaNota) {
        logger.info("Adicionando nota: {}", novaNota);
        validarNota(novaNota);
        novaNota = notaRepository.save(novaNota);
        atualizarMediaFinal(novaNota.getMatricula().getId());

        return novaNota;
    }

    private void validarNota(NotaEntity novaNota) {
        if (novaNota.getMatricula() == null || novaNota.getNota() == null || novaNota.getCoeficiente() == null) {
            throw new NotFoundException("Os campos 'matricula', 'nota' e 'coeficiente' são obrigatórios para adicionar uma nota");
        }

        if (novaNota.getNota() < 0.0 || novaNota.getNota() > 10.0) {
            throw new RuntimeException("A nota do aluno deve estar no intervalo de 0.0 a 10.0");
        }
    }

    private void atualizarMediaFinal(Long idMatricula) {
        DisciplinaMatriculaEntity matricula = disciplinaMatriculaRepository.findById(idMatricula)
                .orElseThrow(() -> new NotFoundException("Matrícula não encontrada com o ID fornecido"));

        Double mediaFinal = calcularMediaFinal(matricula);
        matricula.setMediaFinal(BigDecimal.valueOf(mediaFinal));
        disciplinaMatriculaRepository.save(matricula);
    }

    private Double calcularMediaFinal(DisciplinaMatriculaEntity matricula) {
        List<NotaEntity> notas = matricula.getNotas();
        if (notas.isEmpty()) {
            return 0.0;
        }

        double somaNotasPonderadas = 0.0;
        double somaCoeficientes = 0.0;

        for (NotaEntity nota : notas) {
            somaNotasPonderadas += nota.getNota() * nota.getCoeficiente();
            somaCoeficientes += nota.getCoeficiente();
        }

        return somaNotasPonderadas / somaCoeficientes;
    }


    @Override
    public List<NotaEntity> notasPorMatricula(Long idMatricula) {
        logger.info("Buscando notas na matrícula: {}", idMatricula);
        return notaRepository.findByMatriculaId(idMatricula);
    }


    @Override
    public void excluirNotaPorId(Long idNota) {
        logger.info("Excluindo nota: {}", idNota);
        NotaEntity nota = notaRepository.findById(idNota)
                .orElseThrow(() -> new NotFoundException("Nota não encontrada com o ID fornecido"));

        notaRepository.delete(nota);
        atualizarMediaFinal(nota.getMatricula().getId());
    }
}
