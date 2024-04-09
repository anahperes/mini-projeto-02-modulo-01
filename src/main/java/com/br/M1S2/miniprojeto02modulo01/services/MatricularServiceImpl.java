package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.entities.DTOrequest.DTOrequest;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;
import com.br.M1S2.miniprojeto02modulo01.exception.NotFoundException;
import com.br.M1S2.miniprojeto02modulo01.repository.AlunoRepository;
import com.br.M1S2.miniprojeto02modulo01.repository.DisciplinaMatriculaRepository;
import com.br.M1S2.miniprojeto02modulo01.repository.DisciplinaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatricularServiceImpl implements MatricularService {

    private final DisciplinaMatriculaRepository repository;
    private final AlunoService alunoService;
    private final AlunoRepository alunoRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final DisciplinaService disciplinaService;
    private static final Logger logger = LoggerFactory.getLogger(MatricularServiceImpl.class);

    public MatricularServiceImpl(DisciplinaMatriculaRepository repository, AlunoService alunoService, DisciplinaService disciplinaService, NotasService notasService, AlunoRepository alunoRepository, DisciplinaRepository disciplinaRepository) {
        this.repository = repository;
        this.alunoService = alunoService;
        this.disciplinaService = disciplinaService;
        this.alunoRepository = alunoRepository;
        this.disciplinaRepository = disciplinaRepository;
    }

    @Override
    public DisciplinaMatriculaEntiy matricular(DTOrequest entity) {
        var aluno = alunoService.obterAlunoPorId(entity.getAluno_id());
        var disciplina = disciplinaService.getById(entity.getDisciplina_id());

        if (!alunoRepository.existsById(aluno.getId())) {
            logger.warn("Aluno não encontrado com ID: {}", aluno.getId());
            throw new NotFoundException("Aluno não encontrado com ID: " + aluno.getId());
        }

        if (!disciplinaRepository.existsById(disciplina.getId())) {
            logger.warn("Disciplina não cadastrada");
            throw new NotFoundException("Disciplina não cadastrada");
        }

        DisciplinaMatriculaEntiy matricula = new DisciplinaMatriculaEntiy();
        matricula.setId(null);
        matricula.setAluno(aluno);
        matricula.setDisciplina(disciplina);
        logger.info("Matricula concluida.");

        return repository.save(matricula);
    }

    //Verificar se há notas
    @Override
    public void dell(Long id) throws Exception {
        DisciplinaMatriculaEntiy matricula = getById(id);

        if (!repository.existsById(matricula.getId())) {
            logger.warn("Matricula não encontrada");
            throw new NotFoundException("Matricula não encontrada");
        }

        var notas = matricula.getNotas();
        if (!notas.isEmpty()){
            throw new Exception("Impossível excluir, há notas cadastradas!");
        }
        logger.warn("Matricula excluida");

        repository.delete(matricula);
    }

    //Busca matricula pelo ID informado
    @Override
    public DisciplinaMatriculaEntiy getById(Long id) {
        if (!repository.existsById(id)) {
            logger.warn("Matricula não encontrada com ID: {}", id);
            throw new NotFoundException("Matricula não encontrada com ID: " + id);
        }

        return repository.findById(id).get();
    }

    //Busca as matrículas do aluno de ID informado
    @Override
    public List<DisciplinaMatriculaEntiy> getMatriculasByAlunoId(Long id) {
        if (!alunoRepository.existsById(id)) {
            logger.warn("Aluno não encontrado com ID: {}", id);
            throw new NotFoundException("Aluno não encontrado com ID: " + id);
        }

        var aluno = alunoService.obterAlunoPorId(id);

        List<DisciplinaMatriculaEntiy> list = repository.findAll().stream().filter(x -> x.getAluno()
                .getId().equals(aluno.getId())).collect(Collectors.toList());
        return list;
    }

    //Retornar todas as matrículas de um disciplina
    @Override
    public List<DisciplinaMatriculaEntiy> getTodasDisciplinas(Long id) {
        var matricula = repository.getById(id);

        if (!repository.existsById(matricula.getId())) {
            logger.warn("Não encontrada a matricula de ID: {}", id);
            throw new NotFoundException("Não encontrada a matricula de ID: " + id);
        }

        var disciplina = matricula.getDisciplina();
        if (!repository.existsById(disciplina.getId())) {
            logger.warn("Não cadastrada a disciplina de ID: {}", id);
            throw new NotFoundException("Não cadastrada a disciplina de ID: " + id);
        }
        var idDisciplina = matricula.getDisciplina().getId();

        List<DisciplinaMatriculaEntiy> list = repository.buscaTodasPorDisciplinaPorId(idDisciplina);


        logger.info("Retornando todas as matrículas da disciplina de ID: {}", id);
        return list;
    }


}
