package edu.prj.designpatterns.controller;

import java.util.List;
import java.util.Optional;

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

    @PostMapping("insert")
    public ResponseEntity<Pessoa> insert(@RequestBody Pessoa pessoa) {
        pessoaService.insert(pessoa);
        return ResponseEntity.ok(pessoa);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Pessoa> update(@PathVariable Long id, @RequestBody Pessoa pessoa) {
       Pessoa pessoaAtualizada =  pessoaService.update(id, pessoa);
        return ResponseEntity.ok().body(pessoaAtualizada);
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        pessoaService.deleteById(id);
        return ResponseEntity.ok().body("Registro deletado com Sucesso!");
    }
}
