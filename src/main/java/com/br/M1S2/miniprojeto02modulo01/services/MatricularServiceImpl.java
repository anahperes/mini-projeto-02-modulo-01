package com.br.M1S2.miniprojeto02modulo01.services;
import com.br.M1S2.miniprojeto02modulo01.entities.AlunoEntity;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaEntity;
import com.br.M1S2.miniprojeto02modulo01.entities.DisciplinaMatriculaEntiy;
import com.br.M1S2.miniprojeto02modulo01.repository.DisciplinaMatriculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatricularServiceImpl implements MatricularService {

    private final DisciplinaMatriculaRepository repository;
    private final AlunoService alunoService;
    private final DisciplinaService disciplinaService;

    public MatricularServiceImpl(DisciplinaMatriculaRepository repository, AlunoService alunoService, DisciplinaService disciplinaService, NotasService notasService) {
        this.repository = repository;
        this.alunoService = alunoService;
        this.disciplinaService = disciplinaService;
    }

    @Override
    public DisciplinaMatriculaEntiy matricular(DisciplinaMatriculaEntiy matricula) {
        //ID da matricula gerado automaticamente
        matricula.setId(null);

        //Seta para a matrícula o aluno indicado pelo ID
        AlunoEntity aluno = alunoService.getById((matricula.getAluno().getId()));
        matricula.setAluno(aluno);

        //Seta para a matrícula a disciplina indicada pelo ID
        DisciplinaEntity disciplina = disciplinaService.getById((matricula.getDisciplina().getId()));
        matricula.setDisciplina(disciplina);

        //Salva em DisciplinaMatriculaEntity
        return repository.save(matricula);
    }

    //Verificar se há notas
    @Override
    public void dell(Long id) throws Exception {
        DisciplinaMatriculaEntiy matricula = getById(id);

        //Busca a lista de notas da matrícula a ser excluída
        var notas = matricula.getNotas();

        //Filtro - se há notas cadastradas, lança o erro
        if (!notas.isEmpty()){
            throw new Exception("Impossível excluir, há notas cadastradas!");
        }

        //Estando vazio, exclui
        repository.delete(matricula);
    }


    //Busca matricula pelo ID informado
    @Override
    public DisciplinaMatriculaEntiy getById(Long id) {
        return repository.findById(id).get();
    }

    //Busca as matrículas do aluno de ID informado
    @Override
    public List<DisciplinaMatriculaEntiy> getMatriculasByAlunoId(Long id) {
        var aluno = alunoService.getById(id);
        return null; //aluno.getDisciplinas();
    }

    //Retornar todas as matrículas de um disciplina
    @Override
    public List<DisciplinaMatriculaEntiy> getTodasDisciplinas(Long id) {
        var matricula = repository.getById(id);
        var disciplina = matricula.getDisciplina();
        return null; //disciplina.getMatriculas();
    }

}
