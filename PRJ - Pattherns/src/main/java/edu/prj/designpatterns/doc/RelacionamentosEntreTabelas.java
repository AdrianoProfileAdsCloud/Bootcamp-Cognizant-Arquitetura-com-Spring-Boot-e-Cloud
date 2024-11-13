package edu.prj.designpatterns.doc;

public class RelacionamentosEntreTabelas {

	/**
	 * Explicação
	 * 
	 * @ManyToMany: Define o relacionamento @ManyToMany em ambas as entidades (Aluno
	 *              e Instrutor).
	 * @JoinTable: Na entidade Aluno, usamos a anotação @JoinTable para especificar
	 *             o nome da tabela de junção (Aluno_Instrutor) e as colunas que
	 *             relacionam Aluno e Instrutor. joinColumns: Especifica a coluna
	 *             aluno_id (referência para a entidade Aluno). inverseJoinColumns:
	 *             Especifica a coluna instrutor_id (referência para a entidade
	 *             Instrutor). mappedBy: Na entidade Instrutor, usamos mappedBy para
	 *             indicar que o Set<Instrutor> na classe Aluno é o lado dominante
	 *             da relação. Métodos addInstrutor e addAluno Os métodos
	 *             addInstrutor e addAluno garantem que a relação é mantida em ambos
	 *             os lados (associando um Instrutor a um Aluno e vice-versa), útil
	 *             ao trabalhar com relacionamentos bidirecionais.
	 */

}
