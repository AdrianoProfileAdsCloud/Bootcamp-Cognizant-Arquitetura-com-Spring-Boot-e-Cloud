package edu.prj.designpatterns.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.prj.designpatterns.interfaces.AlunoService;
import edu.prj.designpatterns.interfaces.ViaCepService;
import edu.prj.designpatterns.model.Aluno;
import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Instrutor;
import edu.prj.designpatterns.model.dto.AlunoRequestDTO;
import edu.prj.designpatterns.model.dto.AlunoResponseDTO;
import edu.prj.designpatterns.repository.AlunoRepository;
import edu.prj.designpatterns.repository.EnderecoRepository;
import edu.prj.designpatterns.repository.InstrutorRepository;

@Service
public class AlunoServiceImplementacao implements AlunoService {

	@Autowired
	private ModelMapper modelMapper;

	private AlunoRepository alunoRepository;
	private InstrutorRepository instrutorRepository;
	private EnderecoRepository enderecoRepository;
	private ViaCepService viaCepService;

	public AlunoServiceImplementacao(AlunoRepository alunoRepository, EnderecoRepository enderecoRepository,
			InstrutorRepository instrutorRepository, ViaCepService viaCepService) {
		this.alunoRepository = alunoRepository;
		this.instrutorRepository = instrutorRepository;
		this.enderecoRepository = enderecoRepository;
		this.viaCepService = viaCepService;

	}

	@Override
	@Transactional
	public Aluno create(Aluno aluno, Long idInstrutor) {

	    // Validar entradas
	    if (aluno == null || idInstrutor == null) {
	        throw new IllegalArgumentException("Parâmetros inválidos: aluno ou idInstrutor é nulo.");
	    }

	    // Buscar ou criar o Endereço
	    String cep = aluno.getEndereco().getCep();
	    Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
	        // Caso o endereço não exista, consultar o ViaCEP e persistir o retorno
	        Endereco novoEndereco = viaCepService.consultarCep(cep);
	        return enderecoRepository.save(novoEndereco);
	    });

	    // Definir o endereço no aluno
	    aluno.setEndereco(endereco);

	    // Buscar o Instrutor e associá-lo ao Aluno
	    Optional<Instrutor> instrutorOpt = instrutorRepository.findById(idInstrutor);
	    instrutorOpt.ifPresentOrElse(instrutor -> {
	        // Adiciona o Instrutor ao Aluno
	        aluno.getInstrutores().add(instrutor);
	        
	        // Adiciona o Aluno ao Instrutor para sincronizar o relacionamento bidirecional
	        instrutor.getAlunos().add(aluno);
	    }, () -> {
	        throw new IllegalArgumentException("Instrutor com ID " + idInstrutor + " não encontrado.");
	    });

	    // Salvar Aluno e Instrutor (o cascade ALL na relação irá persistir na tabela de junção)
	    Aluno savedAluno = alunoRepository.save(aluno);

	    return savedAluno;
	}


	@Override
	public void delete(Long id) {

	}

	@Override
	public AlunoResponseDTO upadte(Long id) {
		return null;

	}

	@Override
	public AlunoResponseDTO findById(Long id) {
		return null;
	}

	@Override
	public AlunoResponseDTO findByNome(String nome) {
		return null;
	}

	@Override
	public Iterable getAll() {

		return alunoRepository.findAll();
	}
}
