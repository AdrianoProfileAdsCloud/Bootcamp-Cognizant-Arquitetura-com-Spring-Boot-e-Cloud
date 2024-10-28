package edu.prj.designpatterns.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.prj.designpatterns.model.dto.UserRequestDTO;
import edu.prj.designpatterns.model.dto.UserResponseDTO;
import edu.prj.designpatterns.service.UserService;

/**
 * O ResponseEntity -> É uma classe do Spring Framework utilizada em APIs
 * RESTful para estruturar as respostas de um endpoint (ou seja, as respostas
 * que a API devolve ao cliente que fez uma requisição). Essa classe permite
 * configurar:
 * 
 * O Corpo da Resposta: O conteúdo que será enviado de volta (como uma mensagem
 * de texto, JSON, etc.). O Status HTTP: um código de status que indica se a
 * requisição foi bem-sucedida, se houve erro, etc.
 * Exemplos de códigos de status incluem 200 OK, 404 Not Found, 201 Created. 
 * Os Cabeçalhos HTTP:Informações adicionais sobre a resposta, como tipo de conteúdo
 * (application/json) ou informações de cache. * 
 */

@RestController
@RequestMapping("/users")
@Transactional
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping("/insert")
	public ResponseEntity<Object> postUser(@RequestBody UserRequestDTO user) {
		if (user.getName().isEmpty() || user.getUsername().isEmpty() || user.getPassword().isEmpty()
				|| user.getRoles().isEmpty()) {
			return new ResponseEntity<>("Campos Obrigatórios em Branco", HttpStatus.BAD_REQUEST);
		}
		service.createUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Retorna o objeto do usuário criado com status 201 Created
		return new ResponseEntity<>(user, headers, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> listUsers() {
		List<UserResponseDTO> listUserBd = service.listUser();
		return new ResponseEntity<>(listUserBd, HttpStatus.OK);

	}
}