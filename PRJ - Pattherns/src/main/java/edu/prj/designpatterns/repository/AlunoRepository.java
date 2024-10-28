package edu.prj.designpatterns.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.prj.designpatterns.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Optional<Aluno> findByNome(String nome);
}
