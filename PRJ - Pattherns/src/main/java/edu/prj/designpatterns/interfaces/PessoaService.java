package edu.prj.designpatterns.interfaces;

import java.util.List;
import java.util.Optional;

import edu.prj.designpatterns.model.Pessoa;
import edu.prj.designpatterns.model.dto.PessoaResponseDto;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 *
 * @author falvojr
 */
public interface PessoaService {

	List<PessoaResponseDto> getAll();

	Optional<PessoaResponseDto> findById(Long id);

	Pessoa insert(Pessoa pessoa);

	Pessoa update(Long id, Pessoa pessoa);

	void deleteById(Long id);

}
