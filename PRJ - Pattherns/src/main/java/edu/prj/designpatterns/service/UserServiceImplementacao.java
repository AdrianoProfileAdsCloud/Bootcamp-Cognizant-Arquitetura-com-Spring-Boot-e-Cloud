package edu.prj.designpatterns.service;

import java.util.ArrayList;
import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.prj.designpatterns.interfaces.UserService;
import edu.prj.designpatterns.model.User;
import edu.prj.designpatterns.model.dto.UserRequestDTO;
import edu.prj.designpatterns.model.dto.UserResponseDTO;
import edu.prj.designpatterns.repository.UserRepository;

@Service
@Transactional
public class UserServiceImplementacao implements UserService{
	@Autowired
	private UserRepository repository;
	@Autowired
	private PasswordEncoder encoder;

	@Override
	public UserResponseDTO createUser(@NotNull UserRequestDTO userRequestDTO) {

		User userBD = repository.findByUsername(userRequestDTO.getUsername());
		if (userBD != null) {
			throw new RuntimeException("Login não disponível: " + userRequestDTO.getUsername());
		}
		User newUser = new User(userRequestDTO);
		// criptografando antes de salvar no banco
		 newUser.setPassword(encoder.encode(userRequestDTO.getPassword()));
		 User savedUser = repository.save(newUser);
		return savedUser.userResponseDTO();
	}
  
	@Override
	public List<UserResponseDTO> listUser() {

		List<UserResponseDTO> userRequestDTOs = new ArrayList<>();
		List<User> listUserBD = repository.findAll();
		for (User user : listUserBD) {
			UserResponseDTO listDto = user.userResponseDTO(); // chama o método de conversão
			userRequestDTOs.add(listDto); // adiciona o DTO convertido à lista final
		}

		return userRequestDTOs;
	}

}
