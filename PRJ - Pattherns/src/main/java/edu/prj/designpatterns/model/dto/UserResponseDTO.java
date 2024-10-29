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


public class UserResponseDTO implements Serializable{

		private static final long serialVersionUID = 1L;
		
		private String name;
		private String username;
		private List<String> roles = new ArrayList<>();
				
		public UserResponseDTO(String name,String username,List<String>roles) {
			this.name = name;
			this.username = username;
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
			return Objects.hash(name, roles, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			UserResponseDTO other = (UserResponseDTO) obj;
			return Objects.equals(name, other.name)
					&& Objects.equals(roles, other.roles) && Objects.equals(username, other.username);
		}
	
		

	}
