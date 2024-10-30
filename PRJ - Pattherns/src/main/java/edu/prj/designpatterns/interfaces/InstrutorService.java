package edu.prj.designpatterns.interfaces;

import java.util.List;

import edu.prj.designpatterns.model.Instrutor;
import edu.prj.designpatterns.model.dto.InstrutorRequestDTO;
import edu.prj.designpatterns.model.dto.InstrutorResponseDTO;


public interface InstrutorService {

	InstrutorResponseDTO create(InstrutorRequestDTO instrutorRequestDTO);

    void deleteInstrutor(Long id);

    void updateInstrutor(Long id);

    InstrutorResponseDTO findById(Long id);

    InstrutorResponseDTO findByNome(String nome);
    
    List<InstrutorResponseDTO> findAll();
}
