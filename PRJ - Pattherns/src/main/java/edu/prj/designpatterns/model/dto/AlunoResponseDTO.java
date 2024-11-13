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
 * <p>
 * Fiz uso do Projeto Lombok tem algumas annotations para minimizar o uso de
 * código repetitivo, como gettes e setters e EqualsAndHashCode.Além de não poluir visualmente o código
 */


@NoArgsConstructor //Para uso do Hibernate


public class AlunoResponseDTO {


    private String nome;
    private Endereco endereco;
    private LocalDateTime dataAniversario;
    private int idade;
    private  char sexo;
    private PlanoDePagamentoEnum planoSelecionado;
    private List<Instrutor> instrutores;
    
    public AlunoResponseDTO() {
    	
    }

    public AlunoResponseDTO(Aluno aluno){
    this.nome = aluno.getNome();
    this.endereco = aluno.getEndereco();
    this.dataAniversario = aluno.getDataAniversario();
    this.idade = aluno.getIdade();
    this.sexo = aluno.getSexo();
    this.planoSelecionado = aluno.getPlanoSelecionado();
    this.instrutores = aluno.getInstrutores();
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

	public PlanoDePagamentoEnum getPlanoSelecionado() {
		return planoSelecionado;
	}

	public void setPlanoSeleciondao(PlanoDePagamentoEnum planoSelecionado) {
		this.planoSelecionado = planoSelecionado;
	}

	public List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public void setInstrutores(List<Instrutor> instrutores) {
		this.instrutores = instrutores;
	}


	
}
