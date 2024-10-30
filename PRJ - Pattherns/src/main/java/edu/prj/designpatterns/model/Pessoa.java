package edu.prj.designpatterns.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import edu.prj.designpatterns.model.dto.PessoaRequestDto;
import edu.prj.designpatterns.model.dto.PessoaResponseDto;

/**
 * @autor Adriano Aparecido da Silva
 *
 *        Heranca no Hibernate - Estratégia JOINED. Estratégia que cada classe é
 *        mapeada para uma tabela e a tabela da classe filha tem uma chave
 *        estrangeira que referencia a tabela Pai.
 */

@Entity
@Table(name = "tab_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)

public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 50)
	private String nome;

	@ManyToOne
	private Endereco endereco;// O endereço será preenchido via API externa - ViaCep

	@Column(name = "data_nascimento")
	private LocalDateTime dataAniversario;

	private int idade;

	private char sexo;

	private String cpf;

	public Pessoa(Long idPessoa, String nome, Endereco endereco, LocalDateTime dataAniversario, int idade, char sexo,
			String cpf) {
		this.id = idPessoa;
		this.nome = nome;
		this.endereco = endereco;
		this.dataAniversario = dataAniversario;
		this.idade = idade;
		this.sexo = sexo;
		this.cpf = cpf;
	}

	public Pessoa() {
		
	}

	public PessoaRequestDto pessoaRequestDto() {
		return new PessoaRequestDto(this.nome,this.endereco,this.dataAniversario,this.idade,this.sexo,this.cpf);
	}
	
	public PessoaResponseDto responseDto() {
		return new PessoaResponseDto(this.nome,this.endereco,this.dataAniversario,this.idade,this.sexo);
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
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataAniversario, other.dataAniversario)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id) && idade == other.idade
				&& Objects.equals(nome, other.nome) && sexo == other.sexo;
	}

}
