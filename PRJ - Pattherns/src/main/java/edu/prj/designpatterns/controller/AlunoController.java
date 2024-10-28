package edu.prj.designpatterns.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.prj.designpatterns.interfaces.AlunoService;
import edu.prj.designpatterns.model.Aluno;


@RestController
@RequestMapping("alunos")
public class AlunoController {

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }


    @PostMapping("/{id_instrutor}")
    public ResponseEntity<Aluno> aluno (@RequestBody  Aluno aluno, Long idInstrutor){
        alunoService.insertAluno(aluno,idInstrutor);
        return ResponseEntity.ok(aluno);

    }

    @GetMapping("/findAll")
    public ResponseEntity<Iterable<Aluno>> listAlunos(){
        return ResponseEntity.ok(alunoService.findAll());
    }



}
