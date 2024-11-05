package edu.prj.designpatterns.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.prj.designpatterns.interfaces.PessoaService;
import edu.prj.designpatterns.interfaces.ViaCepService;
import edu.prj.designpatterns.model.Endereco;
import edu.prj.designpatterns.model.Pessoa;
import edu.prj.designpatterns.model.dto.PessoaResponseDTO;
import edu.prj.designpatterns.repository.EnderecoRepository;
import edu.prj.designpatterns.repository.PessoaRepository;

/**
 *  @author Adriano Aparecido da Silva
 * Implementação da <b>Strategy</b> {@link PessoaService}, a qual pode ser
 * injetada pelo Spring via contrutor para evitar acoplamento forte. Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 *
 */
@Service
@Transactional
public class PessoaServiceImplementacao implements PessoaService {

    // Singleton: Injetar os componentes do Spring .

    private final PessoaRepository pessoaRepository;
    private final EnderecoRepository enderecoRepository;
    private final ViaCepService viaCepService;

    public PessoaServiceImplementacao(PessoaRepository pessoaRepository,
                                      EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.pessoaRepository = pessoaRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public List<PessoaResponseDTO> getAll() {
        // Buscar todos os Clientes.
    	PessoaResponseDTO pessoaResponseDto;
        List<Pessoa> pessoas = pessoaRepository.findAll();

        List<PessoaResponseDTO> listPessoaResponseDto = new ArrayList<>();
        for (Pessoa pes : pessoas) {
        	pessoaResponseDto = new PessoaResponseDTO(pes);
            pessoaResponseDto.setId(pes.getId());
            pessoaResponseDto.setNome(pes.getNome());
            pessoaResponseDto.setEndereco(pes.getEndereco());
            pessoaResponseDto.setDataAniversario(pes.getDataAniversario());
            pessoaResponseDto.setIdade(pes.getIdade());
            pessoaResponseDto.setSexo(pes.getSexo());

            listPessoaResponseDto.add(pessoaResponseDto);
        }
        return listPessoaResponseDto;
    }

    @Override
    public Optional<PessoaResponseDTO> findById(Long id) {

    	PessoaResponseDTO responseDto;
        Optional<Pessoa> pessoa =  pessoaRepository.findById(id);
        responseDto = new PessoaResponseDTO(pessoa.get());
             responseDto.setId(pessoa.get().getId());
             responseDto.setNome(pessoa.get().getNome());
             responseDto.setEndereco(pessoa.get().getEndereco());
             responseDto.setDataAniversario(pessoa.get().getDataAniversario());
             responseDto.setIdade(pessoa.get().getIdade());
             responseDto.setSexo(pessoa.get().getSexo());

        return Optional.of(responseDto);
    }

    @Override
    public Pessoa insert(Pessoa pessoa) {
        salvaPessoaComCep(pessoa);
        return pessoaRepository.save(pessoa);
    }

    @Override
    public Pessoa update(Long id, Pessoa pessoaRequest) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(id);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoaToUpdate = pessoaOptional.get();
            pessoaToUpdate.setNome(pessoaRequest.getNome());
            pessoaToUpdate.setCpf(pessoaRequest.getCpf());
            pessoaToUpdate.setEndereco(pessoaRequest.getEndereco());
            pessoaToUpdate.setDataAniversario(pessoaRequest.getDataAniversario());
            pessoaToUpdate.setIdade(pessoaRequest.getIdade());
            pessoaToUpdate.setSexo(pessoaRequest.getSexo());
            pessoaToUpdate.setCpf(pessoaRequest.getCpf());

            salvaPessoaComCep(pessoaRequest);
            return pessoaRepository.save(pessoaToUpdate);
        } else {
            throw new RuntimeException("Pessoa não encontrada com o Id informado " + id);
        }
    }

    @Override
    public void deleteById(Long id) {
        // Deletar Cliente por ID.
        pessoaRepository.deleteById(id);
    }

    public Pessoa salvaPessoaComCep(@NotNull Pessoa pessoa) {
        // Verificar se o Endereco do Cliente já existe (pelo CEP).
        String cep = pessoa.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
            // Caso não exista, integrar com o ViaCEP e persistir o retorno.
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        pessoa.setEndereco(endereco);
        // Inserir Cliente, vinculando o Endereco (novo ou existente).
        pessoaRepository.save(pessoa);
        return pessoa;
    }
}
