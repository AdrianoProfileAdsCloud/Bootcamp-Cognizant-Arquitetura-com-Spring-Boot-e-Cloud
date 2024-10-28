package edu.prj.designpatterns.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.prj.designpatterns.interfaces.InstrutorService;
import edu.prj.designpatterns.model.Instrutor;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    private InstrutorService instrutorService;

    public InstrutorController(InstrutorService instrutorService) {
        this.instrutorService = instrutorService;
    }

    @PostMapping("/insert")
    public ResponseEntity<Instrutor> instrutorResponseEntity (@RequestBody Instrutor instrutor){
        instrutorService.insertInstrutor(instrutor);
        return  ResponseEntity.ok(instrutor);
    }

    @GetMapping
    public ResponseEntity<Iterable<Instrutor>> findAll(){
        Iterable<Instrutor> findAll = instrutorService.findAll();
       return ResponseEntity.ok(findAll);
    }

}
