package edu.prj.designpatterns;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * OpenFeign - Biblioteca de clientes HTTP que permite escrever o código de
 * maneira mais declarativa e simplifica a comunicação com serviços externos em
 * Java. Realiza a integração entre os dois projetos sem que tenhamos que
 * escrever nenhum código para chamar o serviço, além de uma definição de
 * interface.
 *
 * 
 */

@EnableFeignClients
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
