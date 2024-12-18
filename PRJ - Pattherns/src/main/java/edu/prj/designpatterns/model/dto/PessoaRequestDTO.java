package edu.prj.designpatterns.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Pessoa;
import lombok.Data;
import lombok.Getter;

/**
 * @autor Adriano Aparecido da Silva
 *
 */

public class PessoaRequestDTO {

    private Long id;
    private String nome;
    private Endereco endereco;
    private LocalDateTime dataAniversario;
    private int idade;
    private char sexo;
    private String cpf;

    public PessoaRequestDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.endereco = pessoa.getEndereco();
        this.dataAniversario = pessoa.getDataAniversario();
        this.idade = pessoa.getIdade();
        this.sexo = pessoa.getSexo();
        this.cpf = pessoa.getCpf();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataAniversario, endereco, id, idade, nome, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaRequestDTO other = (PessoaRequestDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataAniversario, other.dataAniversario)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id) && idade == other.idade
				&& Objects.equals(nome, other.nome) && sexo == other.sexo;
	}

}
