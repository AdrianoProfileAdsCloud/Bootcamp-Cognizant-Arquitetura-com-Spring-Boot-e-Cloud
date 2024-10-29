package edu.prj.designpatterns.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 * @autor Adriano Aparecido da Silva
 *
 */

@Entity
@Table(name = "tab_instrutor")
public class Instrutor extends Pessoa {


public Instrutor() {
		super();
		
	}

@Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   public Instrutor(Long idPessoa, String nome, Endereco endereco, LocalDateTime dataAniversario,
                    int idade, char sexo, String cpf, Long id) {
      super(idPessoa, nome, endereco, dataAniversario, idade, sexo, cpf);
      this.id = id;
   }
}
