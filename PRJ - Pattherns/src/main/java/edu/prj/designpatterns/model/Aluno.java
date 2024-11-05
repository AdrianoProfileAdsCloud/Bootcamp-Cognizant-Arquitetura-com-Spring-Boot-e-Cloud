package edu.prj.designpatterns.model;

import java.time.LocalDateTime;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import edu.prj.designpatterns.model.dto.AlunoRequestDTO;

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

	@Column(name = "plano_seleciondo")
	@Enumerated(EnumType.STRING)
	private PlanoDePagamentoEnum planoSeleciondo;

	@OneToMany(cascade = { CascadeType.PERSIST, CascadeType.ALL }, fetch = FetchType.LAZY)
	@JoinColumn(name = "aluno_id", referencedColumnName = "id")
	private List<Instrutor> instrutores = new ArrayList<>();

	public Aluno() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlanoDePagamentoEnum getPlanoSeleciondo() {
		return planoSeleciondo;
	}

	public void setPlanoSeleciondo(PlanoDePagamentoEnum planoSeleciondo) {
		this.planoSeleciondo = planoSeleciondo;
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, instrutores, planoSeleciondo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		return Objects.equals(id, other.id) && Objects.equals(instrutores, other.instrutores)
				&& planoSeleciondo == other.planoSeleciondo;
	}

	public void addInstrutor(Instrutor instrutor) {
		instrutores.add(instrutor);
	}
}
