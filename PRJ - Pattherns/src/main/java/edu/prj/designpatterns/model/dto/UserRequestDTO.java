package edu.prj.designpatterns.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import edu.prj.designpatterns.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class UserRequestDTO implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private String name;
		private String username;
		private String password;
		private List<String> roles = new ArrayList<>();
				
		public UserRequestDTO(String name,String username,String password,List<String>roles) {
			this.name = name;
			this.username = username;
			this.password = password;
			this.roles = roles;
		
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

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, password, roles, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserRequestDTO other = (UserRequestDTO) obj;
			return Objects.equals(name, other.name) && Objects.equals(password, other.password)
					&& Objects.equals(roles, other.roles) && Objects.equals(username, other.username);
		}
	
		

	}
