package edu.prj.designpatterns.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.prj.designpatterns.model.Endereco;

/**
 * Client HTTP, criado via OpenFeign, para o consumo da API do ViaCEP.
 *
 * @see <a href="https://spring.io/projects/spring-cloud-openfeign">Spring Cloud
 *      OpenFeign</a>
 * @see <a href="https://viacep.com.br">ViaCEP</a>
 *
 * @author falvojr
 * @author adriano(outras implementaçẽs)
 * 
 *  Facade: Abstrair integrações com subsistemas, provendo uma interface
 *  simples. Neste caso para isso estou fazendo uso do Feign
  */

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

	@GetMapping("/{cep}/json/")
	Endereco consultarCep(@PathVariable("cep") String cep);
}
