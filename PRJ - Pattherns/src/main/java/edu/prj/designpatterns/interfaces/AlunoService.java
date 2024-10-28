package edu.prj.designpatterns.interfaces;

import org.springframework.transaction.annotation.Transactional;

import edu.prj.designpatterns.model.Aluno;
@Transactional
public interface AlunoService {

    Aluno insertAluno(Aluno aluno, Long idInstrutor);

    void deleteAluno(Long id);

    void upadteAluno(Long id);

    Aluno findById(Long id);

    Aluno findByNome(String nome);

    Iterable<Aluno> findAll();

}
