package edu.prj.designpatterns.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * @autor Adriano Aparecido da Silva
 *
 * Fiz uso do Projeto Lombok tem algumas annotations para minimizar o uso de
 * código repetitivo, como gettes e setters e EqualsAndHashCode.Além de não poluir visualmente o código
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
