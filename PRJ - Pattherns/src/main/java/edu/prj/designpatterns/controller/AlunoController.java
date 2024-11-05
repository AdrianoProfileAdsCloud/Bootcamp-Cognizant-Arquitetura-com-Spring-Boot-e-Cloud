package edu.prj.designpatterns.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.prj.designpatterns.interfaces.AlunoService;
import edu.prj.designpatterns.model.Aluno;
import edu.prj.designpatterns.model.dto.AlunoRequestDTO;
import edu.prj.designpatterns.model.dto.AlunoResponseDTO;

@RestController
@RequestMapping("alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@PostMapping("/{idInstrutor}")
	public ResponseEntity<Object> aluno(@RequestBody AlunoRequestDTO alunoRequestDTO, Long idInstrutor) {

		AlunoResponseDTO aluno = alunoService.create(alunoRequestDTO, idInstrutor);	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<>(aluno,headers,HttpStatus.CREATED);

	}

	@GetMapping("/findAll")
	public ResponseEntity<Iterable<AlunoResponseDTO>> getAllAlunos() {
		
		Iterable<AlunoResponseDTO> listAll = alunoService.getAll();		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		// Retorna o objeto do usuário criado com status 201 Created
		return new ResponseEntity<>(listAll, headers, HttpStatus.OK);
	}

}
