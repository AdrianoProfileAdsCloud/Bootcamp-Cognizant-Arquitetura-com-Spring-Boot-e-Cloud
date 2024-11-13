package edu.prj.designpatterns.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.prj.designpatterns.model.dto.InstrutorRequestDTO;

/**
 * @autor Adriano Aparecido da Silva
 */

@Entity
@Table(name = "tab_aluno")
public class Aluno extends Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_aluno")
	private Long id;

	@Column(name = "plano_selecionado")
	@Enumerated(EnumType.STRING)
	private PlanoDePagamentoEnum planoSelecionado;

	@ManyToMany(mappedBy = "alunos",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Instrutor> instrutores= new ArrayList<Instrutor>();

	public Aluno() {

	}
	
	

	public Aluno(Long id, PlanoDePagamentoEnum planoSelecionado, List<Instrutor> instrutores) {
		this.id = id;
		this.planoSelecionado = planoSelecionado;
		this.instrutores = instrutores;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlanoDePagamentoEnum getPlanoSelecionado() {
		return planoSelecionado;
	}

	public void setPlanoSelecionado(PlanoDePagamentoEnum planoSelecionado) {
		this.planoSelecionado = planoSelecionado;
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}

}