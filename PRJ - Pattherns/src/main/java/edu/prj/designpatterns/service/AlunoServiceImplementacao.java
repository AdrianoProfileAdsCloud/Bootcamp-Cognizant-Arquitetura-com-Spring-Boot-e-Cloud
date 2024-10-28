package edu.prj.designpatterns.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import edu.prj.designpatterns.interfaces.AlunoService;
import edu.prj.designpatterns.interfaces.ViaCepService;
import edu.prj.designpatterns.model.Aluno;
import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Instrutor;
import edu.prj.designpatterns.repository.AlunoRepository;
import edu.prj.designpatterns.repository.EnderecoRepository;
import edu.prj.designpatterns.repository.InstrutorRepository;

@Service
public class AlunoServiceImplementacao implements AlunoService {

    private AlunoRepository alunoRepository;
    private InstrutorRepository instrutorRepository;
    private EnderecoRepository enderecoRepository;
    private ViaCepService viaCepService;

    public AlunoServiceImplementacao(AlunoRepository alunoRepository,
                                     EnderecoRepository enderecoRepository,InstrutorRepository instrutorRepository,
                                     ViaCepService viaCepService) {
        this.alunoRepository = alunoRepository;
        this.instrutorRepository = instrutorRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;

    }

    @Override
    public Aluno insertAluno(Aluno aluno, Long idInstrutor) {

        String cep = aluno.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        aluno.setEndereco(endereco);

        Optional<Instrutor> instrutor = instrutorRepository.findById(idInstrutor);
        instrutor.ifPresent(instru -> aluno.getInstrutores().add(instrutor.get()));
        return alunoRepository.save(aluno);
    }


    @Override
    public void deleteAluno(Long id) {

    }

    @Override
    public void upadteAluno(Long id) {

    }

    @Override
    public Aluno findById(Long id) {
        return null;
    }

    @Override
    public Aluno findByNome(String nome) {
        return null;
    }

    @Override
    public Iterable<Aluno> findAll() {

        return alunoRepository.findAll();
    }
}
