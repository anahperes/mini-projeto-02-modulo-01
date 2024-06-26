package com.br.M1S2.miniprojeto02modulo01.service.impl;
import com.br.M1S2.miniprojeto02modulo01.entity.ProfessorEntity;
import com.br.M1S2.miniprojeto02modulo01.exception.NotFoundException;
import com.br.M1S2.miniprojeto02modulo01.repository.ProfessorRepository;
import com.br.M1S2.miniprojeto02modulo01.service.ProfessorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private static final Logger logger = LoggerFactory.getLogger(ProfessorServiceImpl.class);
    private final ProfessorRepository professorRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    @Override
    public List<ProfessorEntity> listarProfessores() {
        logger.info("Listando todos os Professores");
        return professorRepository.findAll();
    }

    @Override
    public ProfessorEntity obterProfessorPorId(Long id) {
        logger.info("Obtendo Professor por ID: {}", id);
        Optional<ProfessorEntity> ProfessorOptional = professorRepository.findById(id);
        if (ProfessorOptional.isPresent()) {
            return ProfessorOptional.get();
        } else {
            logger.warn("Professor não encontrado com o ID: {}", id);
            throw new NotFoundException("Professor não encontrado com o ID: " + id);
        }
    }

    @Override
    public ProfessorEntity adicionarProfessor(ProfessorEntity professor) {
        logger.info("Adicionando novo Professor: {}", professor);
        return professorRepository.save(professor);
    }

    @Override
    public ProfessorEntity atualizarProfessor(Long id, ProfessorEntity professorAtualizado) {
        logger.info("Atualizando Professor com o ID: {}", id);
        if (!professorRepository.existsById(id)) {
            logger.warn("Professor não encontrado com o ID: {}", id);
            throw new NotFoundException("Professor não encontrado com o ID: " + id);
        }
        professorAtualizado.setId(id);
        return professorRepository.save(professorAtualizado);
    }

    @Override
    public void deletarProfessor(Long id) {
        logger.info("Deletando Professor com o ID: {}", id);
        if (!professorRepository.existsById(id)) {
            logger.warn("Professor não encontrado com o ID: {}", id);
            throw new NotFoundException("Professor não encontrado com o ID: " + id);
        }
        professorRepository.deleteById(id);
        logger.info("Professor deletado - ID: {}", id);
    }
}
