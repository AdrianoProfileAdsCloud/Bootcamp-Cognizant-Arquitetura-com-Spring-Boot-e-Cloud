package edu.prj.designpatterns.interfaces;

import java.util.List;

import edu.prj.designpatterns.model.dto.UserRequestDTO;
import edu.prj.designpatterns.model.dto.UserResponseDTO;

public interface UserService {
	
	UserResponseDTO createUser(UserRequestDTO userRequestDTO);
	List<UserResponseDTO> listUser();

}
