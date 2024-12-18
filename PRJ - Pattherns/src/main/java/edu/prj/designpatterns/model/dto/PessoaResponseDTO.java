package edu.prj.designpatterns.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;

import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor Adriano Aparecido da Silva
 *
 */


@NoArgsConstructor //Para uso do Hibernate
@AllArgsConstructor

public class PessoaResponseDTO {

    private Long id;
    private String nome;
    private Endereco endereco;
    private LocalDateTime dataAniversario;
    private int idade;
    private char sexo;


    public PessoaResponseDTO(Pessoa pessoa){
        this.id = pessoa.getId();
        this.nome = pessoa.getNome();
        this.endereco = pessoa.getEndereco();
        this.dataAniversario = pessoa.getDataAniversario();
        this.idade = pessoa.getIdade();
        this.sexo = pessoa.getSexo();

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


	@Override
	public int hashCode() {
		return Objects.hash(dataAniversario, endereco, id, idade, nome, sexo);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaResponseDTO other = (PessoaResponseDTO) obj;
		return Objects.equals(dataAniversario, other.dataAniversario) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && idade == other.idade && Objects.equals(nome, other.nome)
				&& sexo == other.sexo;
	}

}
