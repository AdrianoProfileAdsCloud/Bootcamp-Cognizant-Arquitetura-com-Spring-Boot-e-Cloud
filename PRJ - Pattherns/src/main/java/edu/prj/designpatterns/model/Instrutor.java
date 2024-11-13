package edu.prj.designpatterns.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @autor Adriano Aparecido da Silva
 *
 */

@Entity
@Table(name = "tab_instrutor")
public class Instrutor extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long id;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name = "instrutor_alunos",
	joinColumns = @JoinColumn(name = "id_instrutor"),
	inverseJoinColumns = @JoinColumn(name = "id_aluno"))
	private List<Aluno> alunos = new ArrayList<Aluno>();

	public Instrutor(Long idPessoa, String nome, Endereco endereco, LocalDateTime dataAniversario, int idade, char sexo,
			String cpf, Long id) {
		super(idPessoa, nome, endereco, dataAniversario, idade, sexo, cpf);
		this.id = id;
	}

	public Instrutor() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}
	

}
