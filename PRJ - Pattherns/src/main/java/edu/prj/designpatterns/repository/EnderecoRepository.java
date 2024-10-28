package edu.prj.designpatterns.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.prj.designpatterns.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco,String>{

}
