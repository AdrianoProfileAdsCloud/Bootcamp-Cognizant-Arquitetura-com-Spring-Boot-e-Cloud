package edu.prj.designpatterns.doc;

public class DtosExplicacao {

	/**
	 * DTO – Objeto de Transferencia de Dados Ideia do Post A ideia deste post é
	 * apresentar o conceito do Padrão DTO e as conversões entre entidades internas
	 * da aplicação e os DTOs externos publicados de volta para o cliente.
	 * 
	 * Padrão de arquitetura O wikipedia define padrão de arquitetura como: “…uma
	 * solução geral e reutilizável para um problema que ocorre com frequência em
	 * arquitetura de software dentro de um determinado contexto….”
	 * 
	 * Um Padrão de arquitetura é uma solução genérica que pode ser repetida de uma
	 * forma geral para um problema comum no design de software. Como o próprio nome
	 * sugere, não é algo acabado que pode ser transformado diretamente em algum
	 * tipo de código. É um modelo ou uma forma de resolver determinado problema que
	 * pode ser usado em várias situações diferentes. Nesse post iremos falar um
	 * pouco sobre um padrão de arquitetura bastante utilizado no desenvolvimento de
	 * aplicações.
	 * 
	 * DTO – Objeto de Transferencia de Dados Padrão Objeto de Transferência de
	 * Dados (do inglês, Data transfer object design pattern, ou simplesmente DTO) é
	 * um padrão de arquitetura de objetos que agregam e encapsulam dados para
	 * transferência.
	 * 
	 * Diferente do que ocorre com os objetos de negócio e os objetos de acesso a
	 * dados (DAO), o DTO não possui qualquer tipo de comportamento. A sua função é
	 * obter e armazenar dados. Quando estamos trabalhando com uma interface remota,
	 * cada chamada ao servidor pode custar muito tempo de processamento, a depender
	 * da quantidade de dados. Com o DTO, podemos filtrar quais dados serão
	 * transmitidos e assim reduzir esse problema.
	 * 
	 * O DTO é bastante utilizado também quando não queremos expor todos os dados da
	 * nossa camada de persistência mas precisamos exibir ao nosso cliente estes
	 * mesmos dados. Vamos focar nosso post nessa linha de raciocício.
	 * 
	 * Entendendo o contexto da aplicação Utilizaremos como exemplo uma API REST
	 * criada com Spring Boot e que possui uma área de cadastro de usuários no
	 * sistema.
	 * 
	 * Essa é a classe que representa os usuários na nossa API:
	 * 
	 * Modelo de Classes
	 * 
	 * A parte em que queremos focar, do nosso Controller de usuários, ficou assim:
	 * 
	 * Modelo de Classes
	 * 
	 * O método responsável pela criação de um usuário na nossa aplicação espera
	 * como parâmetro um objeto do tipo Usuario. Este será recebido num formato
	 * Json, no corpo da requisição, passará pela nossa regra de negócio na camada
	 * Service e posteriormente será persistido no banco de dados na nossa camada
	 * repository (Esses passos foram abstraídos no exemplo e nas imagens mas eles
	 * estão lá).
	 * 
	 * Nesse momento começamos a perceber uma falha grave de segurança da nossa
	 * aplicação. Analisando nossa classe Usuario, veremos que ela possui um
	 * atributo do tipo booleano, “Admin”, inicializada com o valor “false”.
	 * 
	 * Modelo de Classes
	 * 
	 * Logo, caso seja passado o valor “true” para este parâmetro na requisição,
	 * qualquer um poderá se tornar administrador da nossa aplicação. A
	 * possibilidade de tornar um usuário em administrador não deve ser algo
	 * acessível a qualquer um. Exige uma lógica, um tratamento individual na nossa
	 * aplicação, seguindo regras que nós como os desenvolvedores do projeto iremos
	 * estabelecer. Sendo assim, o atributo “Admin” não deve ser considerado como um
	 * possível parâmetro de entrada a ser recebido por meio deste tipo de
	 * requisição.
	 * 
	 * Aliás, se tivéssemos uma classe apenas com os atributos essenciais para a
	 * criação de um usuário, não correríamos esse tipo de risco. Poderíamos usá-la
	 * para receber os parâmetros, e assim manipulá-los da forma que quisermos.
	 * 
	 * A ideia do DTO é essa.
	 * 
	 * Vamos criar uma classe que, seguindo a convenção, se chamará UsuarioDTO e
	 * vamos dizer que esperamos um objeto desse tipo como parâmetro do método
	 * salvar() do nosso UsuarioController. Nesta classe vamos usar apenas os
	 * atributos que de fato devem ser passados pelo cliente.
	 * 
	 * A permissão para transformar um usuário em Admin será feito posteriormente
	 * numa lógica seguindo a regra para tal. Como anotamos o id da nossa classe
	 * Usuario com @GeneratedValue, ele será gerado automaticamente, não sendo assim
	 * necessario neste momento.
	 * 
	 * Dessa forma teremos como atributos da nossa classe UsuarioDTO apenas nome,
	 * email e senha:
	 * 
	 * Modelo de Classes
	 * 
	 * Agora sim podemos, em vez de, receber um Usuario com todos os atributos,
	 * iremos receber um UsuarioDTO com apenas os atributos necessários para a
	 * criação do usuário.
	 * 
	 * Modelo de Classes
	 * 
	 * Só que agora temos um novo problema. O método salvar() do nosso
	 * UsuarioService, espera um Usuario como parâmetro, e não um UsuarioDTO. Isso é
	 * simples de resolver e existem diversas formas de fazer isso. Podemos falar
	 * sobre isso num outro post. Neste post aqui nós iremos fazer a conversão DTO –
	 * Entity utilizando a biblioteca ModelMapper.
	 * 
	 * DOC ModelMapper
	 * 
	 * Adicionando o Model Mapper ao nosso projeto Para podermos utilizar o
	 * modelMapper em nosso projeto precisamos adicionar sua dependência no pom.xml:
	 * 
	 * Modelo de Classes
	 * 
	 * É necessário também definirmos o bean ModelMapper em nossa configuração do
	 * Spring:
	 * 
	 * Modelo de Classes
	 * 
	 * Como funciona O Model Mapper, entre outros, possui um método chamado map(),
	 * que espera receber dois parâmetros. O primeiro seria o objeto que estamos
	 * querendo converter e o segundo, a classe destino. Recebidos os dois
	 * parâmetros, estes serão analisados ​​para determinar quais propriedades
	 * correspondem implicitamente de acordo com uma estratégia de correspondência e
	 * outra configuração. Traduzindo… serão checadas quais propriedades o objeto de
	 * origem têm em comum com a classe de destino, mapeando de acordo com essas
	 * correspondências. Dessa forma criaremos um método específico para fazer essa
	 * conversão. No nosso exemplo ficará assim:
	 * 
	 * Modelo de Classes
	 * 
	 * E nosso salvar() do UsuarioController ficará dessa forma:
	 * 
	 * Modelo de Classes
	 * 
	 * Porém ainda temos um problema. Tanto a classe Usuario, como UsuarioDTO,
	 * possuem o atributo senha. Dessa forma ao enviarmos um Usuario ou até mesmo um
	 * UsuarioDTO para o Cliente como resposta a requisição, a senha deste ficará
	 * visível gerando uma nova falha de segurança. Quando enviamos uma resposta,
	 * queremos passar as informações do usuário para o cliente sem informar a
	 * senha. Como podemos fazer isso? É isso mesmo. Vamos criar um novo DTO e esse
	 * será exclusivo para respostas ao cliente. O nome dessa classe será
	 * UsuarioRespostaDTO e ficará assim:
	 * 
	 * Modelo de Classes
	 * 
	 * Assim como fizemos com o UsuarioDTO, precisaremos agora converter um Usuario
	 * em UsuarioRespostaDTO. De forma similar criaremos um método para isso:
	 * 
	 * Modelo de Classes
	 * 
	 * Por fim o retorno do método salvar() do nosso Controller será:
	 * 
	 * Modelo de Classes
	 * 
	 * 
	 */

}
