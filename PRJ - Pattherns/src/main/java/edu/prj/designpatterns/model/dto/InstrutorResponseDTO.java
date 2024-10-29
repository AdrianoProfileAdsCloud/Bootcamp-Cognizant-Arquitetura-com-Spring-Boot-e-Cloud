package edu.prj.designpatterns.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import edu.prj.designpatterns.model.Endereco;

/**
 * ModelMapper -> É uma biblioteca para converter objetos entre tipos
 * diferentes, como por exemplo: UserRequestDTO para User. 
 * 
 * O uso da biblioteca ModelMapper aqui é para validar , o conhecimento de formas para faciliatar
 * o desenvolvimento.Motivo pelo qual inicialmente foi criado um mecanismo de convresão de entidades na mão, pois antes
 * do uso de qualquer biblioteca é necessário saber que problema ou facilidade a mesma se propoem.
 */

public class InstrutorResponseDTO {

	private String nome;
	private Endereco endereco;
	private LocalDateTime dataAniversario;
	private int idade;
	private char sexo;
	//private String cpf; para administradores criar regra
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(dataAniversario, endereco, idade, nome, sexo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InstrutorResponseDTO other = (InstrutorResponseDTO) obj;
		return Objects.equals(dataAniversario, other.dataAniversario)
				&& Objects.equals(endereco, other.endereco) && idade == other.idade && Objects.equals(nome, other.nome)
				&& sexo == other.sexo;
	}
	
	

}
