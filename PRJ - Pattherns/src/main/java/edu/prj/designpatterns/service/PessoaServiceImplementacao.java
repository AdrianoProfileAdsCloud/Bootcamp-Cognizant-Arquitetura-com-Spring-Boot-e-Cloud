package edu.prj.designpatterns.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.prj.designpatterns.interfaces.PessoaService;
import edu.prj.designpatterns.interfaces.ViaCepService;
import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Pessoa;
import edu.prj.designpatterns.model.User;
import edu.prj.designpatterns.model.dto.PessoaRequestDto;
import edu.prj.designpatterns.model.dto.PessoaResponseDto;
import edu.prj.designpatterns.repository.EnderecoRepository;
import edu.prj.designpatterns.repository.PessoaRepository;

/**
 * @author Adriano Aparecido da Silva Implementação da Strategy
 *         {@link PessoaService}, a qual pode ser injetada pelo Spring via
 *         construtor para evitar acoplamento forte. Com isso, como essa classe
 *         é um {@link Service}, ela será tratada como um Singleton.
 *
 */
@Service
@Transactional
public class PessoaServiceImplementacao implements PessoaService {

	/** Singleton: Injetar os componentes do Spring. **/

	private final PessoaRepository pessoaRepository;
	private final EnderecoRepository enderecoRepository;
	private final ViaCepService viaCepService;

	public PessoaServiceImplementacao(PessoaRepository pessoaRepository, EnderecoRepository enderecoRepository,
			ViaCepService viaCepService) {
		this.pessoaRepository = pessoaRepository;
		this.enderecoRepository = enderecoRepository;
		this.viaCepService = viaCepService;
	}

	/** Strategy: Implementar os métodos definidos na interface. **/
	@Override
	public List<PessoaResponseDto> getAll() {

		List<PessoaResponseDto> listPessoaResponseDto = new ArrayList<>();
		List<Pessoa> pessoas = pessoaRepository.findAll();
		for (Pessoa pessoa : pessoas) {
			PessoaResponseDto pessoaResponse = pessoa.responseDto();
			listPessoaResponseDto.add(pessoaResponse);
		}
		return listPessoaResponseDto;
	}

	/** Strategy: Implementar os métodos definidos na interface. **/
	@Override
	public Optional<PessoaResponseDto> findById(Long id) {

		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		PessoaResponseDto pessoaResponse = pessoa.get().responseDto();

		return Optional.of(pessoaResponse);
	}

	/** Strategy: Implementar os métodos definidos na interface. **/
	@Override
	public PessoaResponseDto create(PessoaRequestDto pessoaRequest) {
		Pessoa newPessoa = salvarPessoaComCep(pessoaRequest);
		Pessoa savedPessoa = pessoaRepository.save(newPessoa);
		return savedPessoa.responseDto();
	}

	/** Strategy: Implementar os métodos definidos na interface. **/
	@Override
	public PessoaResponseDto update(Long id, PessoaRequestDto pessoaRequestDto) {
		
		Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
		if (pessoaOptional.isPresent()) {
			Pessoa newPessoa = salvarPessoaComCep(pessoaRequestDto);
			Pessoa savedPessoa = pessoaRepository.save(newPessoa);
			return savedPessoa.responseDto();
		} else {
			throw new RuntimeException("Pessoa não encontrada com o Id informado " + id);
		}
	}

	/** Strategy: Implementar os métodos definidos na interface. **/
	@Override
	public void deleteById(Long id) {
		// Deletar Cliente por ID.
		pessoaRepository.deleteById(id);
	}

	public Pessoa salvarPessoaComCep(PessoaRequestDto pessoaRequestDto) {

		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = pessoaRequestDto.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {

			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});

		Pessoa newpessoa = new Pessoa();
		newpessoa.setEndereco(endereco);

		// Cria Cliente, vinculando o Endereco (novo ou existente).

		Pessoa savedPessoa = pessoaRepository.save(newpessoa);
		return savedPessoa;
	}

}
