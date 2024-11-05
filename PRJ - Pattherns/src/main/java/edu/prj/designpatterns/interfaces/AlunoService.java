package edu.prj.designpatterns.interfaces;

import org.springframework.transaction.annotation.Transactional;

import edu.prj.designpatterns.model.dto.AlunoRequestDTO;
import edu.prj.designpatterns.model.dto.AlunoResponseDTO;

@Transactional
public interface AlunoService {

	AlunoResponseDTO create(AlunoRequestDTO alunoRequestDTO, Long idInstrutor);

	void delete(Long id);

	AlunoResponseDTO upadte(Long id);

	AlunoResponseDTO findById(Long id);

	AlunoResponseDTO findByNome(String nome);

	Iterable<AlunoResponseDTO> getAll();

}
