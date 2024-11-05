package edu.prj.designpatterns.model.dto;

/***
 * Os Records são uma nova forma de declarar classes no Java. Eles são imutáveis
 * por padrão, o que significa que não podemos alterar seus valores após a
 * criação do objeto,são úteis para representar
 * dados, como, por exemplo, uma entidade de banco de dados.
 * 
 * Esse recurso foi introduzido no Java 14 como experimental, e a partir do Java
 * 16 foi marcado como estável. Isso significa que podemos utilizá-lo em nossos
 * projetos sem medo de que ele seja removido em uma versão futura do Java.
 * 
 * Vantagens e Desvantagens de utilizar Records:
 * 
 * Sintaxe mais concisa -> Records permitem definir classes de dados imutáveis de
 * forma mais concisa, eliminando a necessidade de escrever o código repetitivo
 * que normalmente é necessário para definir uma classe Java. 
 * 
 * Redução de código-> boilerplate: Como os Records fornecem métodos padrão, como equals(),
 * hashCode() e toString(), eles reduzem a quantidade de código boilerplate
 * necessário para definir uma classe Java. Imutabilidade: Como os Records são
 * imutáveis por padrão, eles fornecem uma maneira mais segura e fácil de
 * trabalhar com dados imutáveis.
 * 
 *  Mais fácil de ler e manter -> A sintaxe
 * simplificada do Records torna mais fácil de ler e manter o código, pois é
 * mais fácil de entender a intenção do código. 
 * 
 * Melhor compatibilidade com APIs existentes -> Os Records foram projetados para serem compatíveis com as APIs
 * existentes, permitindo que os desenvolvedores usem Records em conjunto com
 * outras classes Java sem problemas. 
 * 
 * Por outro lado, eles também possuem algumas desvantagens, como, por exemplo:
 * 
 * Restrições na personalização de métodos-> Por padrão, os Records fornecem
 * métodos padrão, como equals(), hashCode() e toString(), que não podem ser
 * personalizados. Embora seja possível fornecer uma implementação personalizada
 * desses métodos, isso pode ser menos conveniente do que simplesmente
 * estendê-los ou anulá-los em uma classe normal. 
 * 
 * Limitações na herança-> Os Records não suportam herança de classe, o que significa que não é possível
 * estender um Record em outra classe. Isso pode ser um problema se você
 * precisar adicionar funcionalidade a uma classe Record existente. 
 * 
 * Maior complexidade em casos complexos-> Em casos complexos, os Records podem se
 * tornar mais difíceis de entender e manter do que as classes Java normais,
 * devido a uma sintaxe mais compacta e a recursos específicos que podem ser
 * difíceis de entender.
 * 
 * Restrições de visibilidade -> a visibilidade dos campos e
 * métodos em um record é limitada. Todos os campos são automaticamente finais e
 * privados, e os métodos são todos públicos.
 * 
 *   Concluindo - Assim como tudo temos que entender a estrutura do projeto para adota-lo ou não! 
 *   Fiz seu uso aqui por endender que neste caso não teria tantos "contras" ou neste caso nenhum a principio
 *   Uma forma de demonstar meu conhecimento sobre essa forma de se criar um DTO.
 */

public record SessaoRecordDTO(String login, String token) {
}
