package edu.prj.designpatterns.service;


import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.prj.designpatterns.interfaces.InstrutorService;
import edu.prj.designpatterns.interfaces.ViaCepService;
import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Instrutor;
import edu.prj.designpatterns.model.dto.InstrutorRequestDTO;
import edu.prj.designpatterns.model.dto.InstrutorResponseDTO;
import edu.prj.designpatterns.repository.EnderecoRepository;
import edu.prj.designpatterns.repository.InstrutorRepository;


@Service
public class InstrutorServiceImplementacao implements InstrutorService {
	
	@Autowired
    private ModelMapper modelMapper;

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
    public Instrutor insertInstrutor(InstrutorRequestDTO instrutorRequestDTO) {
        
        String cep = instrutorRequestDTO.getEndereco().getCep();
        
        // Busca o endereço pelo CEP ou cria um novo usando o ViaCEP
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            return enderecoRepository.save(novoEndereco);
        });
        
        // Converte InstrutorRequestDTO para Instrutor usando ModelMapper
        Instrutor instrutor = modelMapper.map(instrutorRequestDTO, Instrutor.class);
        
        // Atribui o Endereco encontrado ao Instrutor
        instrutor.setEndereco(endereco);
        
        // Salva o Instrutor no banco de dados e retorna
        instrutor = instrutorRepository.save(instrutor);
        return instrutor;
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
    public InstrutorResponseDTO findByNome(String nome) {
        return null;
    }

    @Override
    public List<InstrutorResponseDTO> findAll() {
    	List<InstrutorResponseDTO> list = new ArrayList<InstrutorResponseDTO>();
    	List<Instrutor> listIntrutores = instrutorRepository.findAll();
    	for (Instrutor instrutor : listIntrutores) {
    		list.add(modelMapper.map(instrutor, InstrutorResponseDTO.class));
		}
    	
		return list;   	
         
    }
    
   
}
