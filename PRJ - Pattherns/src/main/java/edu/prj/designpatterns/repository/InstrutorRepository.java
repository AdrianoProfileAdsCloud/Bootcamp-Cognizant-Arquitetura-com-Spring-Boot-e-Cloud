package edu.prj.designpatterns.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.prj.designpatterns.model.Instrutor;

public interface InstrutorRepository extends JpaRepository<Instrutor,Long> {
}
