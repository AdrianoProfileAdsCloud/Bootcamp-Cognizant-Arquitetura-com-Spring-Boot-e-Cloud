package edu.prj.designpatterns.service;

import java.util.Optional;

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
	public AlunoResponseDTO create(AlunoRequestDTO alunoRequestDTO, Long idInstrutor) {

		String cep = alunoRequestDTO.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});

		// Mapear AlunoRequestDTO para Aluno
		Aluno aluno = modelMapper.map(alunoRequestDTO, Aluno.class);
		aluno.setEndereco(endereco);

		// Salvar Aluno
		Aluno savedAluno = alunoRepository.save(aluno);

		// Mapear Aluno para AlunoResponseDTO
		return modelMapper.map(savedAluno, AlunoResponseDTO.class);

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
	public Iterable<AlunoResponseDTO> getAll() {

		// return alunoRepository.findAll();
		return null;
	}
}
