package edu.prj.designpatterns.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import edu.prj.designpatterns.model.dto.UserRequestDTO;
import edu.prj.designpatterns.model.dto.UserResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @autor Adriano Aparecido da Silva
 *        <p>
 *        Fiz uso do Projeto Lombok tem algumas annotations para minimizar o uso
 *        de código repetitivo, como gettes e setters e EqualsAndHashCode.Além
 *        de não poluir visualmente o código
 */

@Entity
@Table(name = "tab_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private Long id;

	@Column(length = 50, nullable = false)
	private String name;

	@Column(length = 20, nullable = false)
	private String username;

	@Column(length = 100, nullable = false)
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "tab_user_roles", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "role_id")
	private List<String> roles = new ArrayList<>();

	public User() {

	}

	public UserRequestDTO userRequestDTO() {
		return new UserRequestDTO(this.name, this.username,this.password,this.roles);
	}
	
	public UserResponseDTO userResponseDTO() {
		return new UserResponseDTO(this.name, this.username,this.roles);
	}
	
	public User (UserRequestDTO userRequestDTO) {
		this.name = userRequestDTO.getName();
		this.username = userRequestDTO.getUsername();
		this.password = userRequestDTO.getPassword();
		this.roles = userRequestDTO.getRoles();	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, password, roles, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(username, other.username);
	}

}