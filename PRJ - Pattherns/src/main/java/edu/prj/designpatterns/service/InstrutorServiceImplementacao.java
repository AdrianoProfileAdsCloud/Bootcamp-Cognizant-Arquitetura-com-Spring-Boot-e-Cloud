package edu.prj.designpatterns.service;


import org.springframework.stereotype.Service;

import edu.prj.designpatterns.interfaces.InstrutorService;
import edu.prj.designpatterns.interfaces.ViaCepService;
import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Instrutor;
import edu.prj.designpatterns.repository.EnderecoRepository;
import edu.prj.designpatterns.repository.InstrutorRepository;


@Service
public class InstrutorServiceImplementacao implements InstrutorService {

    private InstrutorRepository instrutorRepository;
    EnderecoRepository enderecoRepository ;
    ViaCepService viaCepService;

    public InstrutorServiceImplementacao(InstrutorRepository instrutorRepository,
                                         EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.instrutorRepository = instrutorRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    @Override
    public Instrutor insertInstrutor(Instrutor instrutor) {
        String cep = instrutor.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        instrutor.setEndereco(endereco);
        return instrutorRepository.save(instrutor);
    }

    @Override
    public void deleteInstrutor(Long id) {

    }

    @Override
    public void updateInstrutor(Long id) {

    }

    @Override
    public Instrutor findById(Long id) {
        return null;
    }

    @Override
    public Instrutor findByNome(String nome) {
        return null;
    }

    @Override
    public Iterable<Instrutor> findAll() {
      return   instrutorRepository.findAll();
    }
}
