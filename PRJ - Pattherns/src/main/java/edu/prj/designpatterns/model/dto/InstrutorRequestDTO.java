package edu.prj.designpatterns.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import edu.prj.designpatterns.model.Endereco;

/**
 * ModelMapper -> É uma biblioteca para converter objetos entre tipos
 * diferentes, como por exemplo: UserRequestDTO para User. 
 */

public class InstrutorRequestDTO {

	private String nome;
	private Endereco endereco;
	private LocalDateTime dataAniversario;
	private int idade;
	private char sexo;
	private String cpf;
	
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
		return Objects.hash(cpf, dataAniversario, endereco, idade, nome, sexo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstrutorRequestDTO other = (InstrutorRequestDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataAniversario, other.dataAniversario)
				&& Objects.equals(endereco, other.endereco) && idade == other.idade && Objects.equals(nome, other.nome)
				&& sexo == other.sexo;
	}
	
	

}
