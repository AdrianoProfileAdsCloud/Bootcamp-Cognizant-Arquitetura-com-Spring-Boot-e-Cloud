package edu.prj.designpatterns.model.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.prj.designpatterns.model.Aluno;
import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Instrutor;
import edu.prj.designpatterns.model.PlanoDePagamentoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor Adriano Aparecido da Silva
 *
 */

public class AlunoRequestDTO {

	private String nome;
	private Endereco endereco;
	private LocalDateTime dataAniversario;
	private int idade;
	private char sexo;
	private String cpf;
	private PlanoDePagamentoEnum planoSelecionado;
	private List<Instrutor> instrutores = new ArrayList<>();

	public AlunoRequestDTO(String nome, Endereco endereco, LocalDateTime dataAniversario, int idade, char sexo,
			String cpf, PlanoDePagamentoEnum planoSeleciondo, List<Instrutor> instrutores) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataAniversario = dataAniversario;
		this.idade = idade;
		this.sexo = sexo;
		this.cpf = cpf;
		this.planoSelecionado = planoSeleciondo;
		this.instrutores = instrutores = new ArrayList<Instrutor>();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public LocalDateTime getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(LocalDateTime dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public void addInstrutores(Instrutor instrutor) {
		instrutores.add(instrutor);
	}

}
