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

/**
 * @autor Adriano Aparecido da Silva
 *
 *        A anotação @Inheritance(strategy = InheritanceType.JOINED) em JPA é
 *        usada para definir estratégias de herança entre classes de entidades
 *        em um banco de dados relacional.
 * 
 *        Quando você define essa anotação com InheritanceType.JOINED, a JPA
 *        cria uma tabela para cada classe na hierarquia de herança. Em vez de
 *        ter todas as colunas em uma única tabela, cada tabela armazena os
 *        dados específicos da classe e usa uma chave estrangeira para
 *        referenciar a tabela base. Essa estratégia é útil para evitar a
 *        duplicação de dados, especialmente quando há muitos atributos
 *        específicos em subclasses.
 * 
 * 
 */

@Entity
@Table(name = "tab_pessoa")
@Inheritance(strategy = InheritanceType.JOINED)

public class Pessoa {

	public Pessoa() {

	}

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

	public Pessoa(Long id, String nome, Endereco endereco, LocalDateTime dataAniversario, int idade, char sexo,
			String cpf) {
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.dataAniversario = dataAniversario;
		this.idade = idade;
		this.sexo = sexo;
		this.cpf = cpf;
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
