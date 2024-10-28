package edu.prj.designpatterns.interfaces;

import edu.prj.designpatterns.model.Instrutor;


public interface InstrutorService {

    Instrutor insertInstrutor(Instrutor instrutor);

    void deleteInstrutor(Long id);

    void updateInstrutor(Long id);

    Instrutor findById(Long id);

    Instrutor findByNome(String nome);
    Iterable<Instrutor> findAll();
}
