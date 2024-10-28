package edu.prj.designpatterns.model.dto;

/**
 * Record -> É um tipo de classe que armazena dados. É a mesma ideia de construção similar a um JavaBean,
 * possui construtor, atributos e métodos acessores. Porém, ao invés de possibilitar qualquer alteração a 
 * classe é imutável. Também possui os métodos equals, hashCode e toString().
 * Algumas boas vantagens a se considerar na utilização de records:
 * Diminuir escrita de código boilerplate
 * Tirar a necessidade de bibliotecas que fazem esse trabalho, como por exemplo, Lombok
 *  Imutabilidade
 */

public record LoginRecordRequest(String username,String password) {
}
