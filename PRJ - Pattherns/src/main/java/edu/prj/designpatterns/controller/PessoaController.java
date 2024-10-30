package edu.prj.designpatterns.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.prj.designpatterns.interfaces.PessoaService;
import edu.prj.designpatterns.model.Pessoa;
import edu.prj.designpatterns.model.dto.PessoaRequestDto;
import edu.prj.designpatterns.model.dto.PessoaResponseDto;

/**
 * Esse {@link RestController} representa nossa <b>Facade</b>, pois abstrai toda
 * a complexidade de integrações (Banco de Dados H2 e API do ViaCEP) em uma
 * interface simples e coesa (API REST).
 *
 * @author falvojr
 */
@RestController
@RequestMapping("pessoas")
public class PessoaController {

	private PessoaService pessoaService;

	public PessoaController(PessoaService pessoaService) {
		this.pessoaService = pessoaService;
	}

	@GetMapping("getAll")
	public ResponseEntity<List<PessoaResponseDto>> getAll() {
		return ResponseEntity.ok(pessoaService.getAll());
	}

	@GetMapping("findById/{id}")
	public ResponseEntity<Optional<PessoaResponseDto>> findById(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaService.findById(id));
	}

	@PostMapping("create")
	public ResponseEntity<Object> insert(@RequestBody PessoaRequestDto pessoaRequesDto) {

		pessoaService.create(pessoaRequesDto);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Retorna o objeto do usuário criado com status 201 Created
		return new ResponseEntity<>(pessoaRequesDto, headers, HttpStatus.CREATED);

	}

	@PutMapping("update/{id}")
	public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody PessoaRequestDto pessoRequesDto) {
		
		PessoaResponseDto pessoaAtualizada = pessoaService.update(id, pessoRequesDto);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// Retorna o objeto do usuário criado com status 201 Created
		return new ResponseEntity<>(pessoRequesDto, headers, HttpStatus.CREATED);

	}

	@DeleteMapping("deleteById/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		pessoaService.deleteById(id);
		return ResponseEntity.ok().body("Registro deletado com Sucesso!");
	}
}
