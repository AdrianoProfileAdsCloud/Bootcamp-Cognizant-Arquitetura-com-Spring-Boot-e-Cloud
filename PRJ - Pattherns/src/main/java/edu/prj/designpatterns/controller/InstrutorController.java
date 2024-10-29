package edu.prj.designpatterns.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.prj.designpatterns.interfaces.InstrutorService;
import edu.prj.designpatterns.model.Instrutor;
import edu.prj.designpatterns.model.dto.InstrutorRequestDTO;
import edu.prj.designpatterns.model.dto.InstrutorResponseDTO;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

	private InstrutorService instrutorService;

	public InstrutorController(InstrutorService instrutorService) {
		this.instrutorService = instrutorService;
	}

	@PostMapping("/insert")
	public ResponseEntity<Object> instrutorResponseEntity(@RequestBody InstrutorRequestDTO instrutorRequestDTO) {

		Instrutor instrutor = instrutorService.insertInstrutor(instrutorRequestDTO);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Retorna o objeto do usuário criado com status 201 Created
		return new ResponseEntity<>(instrutor, headers, HttpStatus.CREATED);

	}

	@GetMapping
	public ResponseEntity<Iterable<InstrutorResponseDTO>> findAll() {
		
		List<InstrutorResponseDTO> listAll = instrutorService.findAll();		
		return new ResponseEntity<>(listAll,HttpStatus.OK);
	}

}
