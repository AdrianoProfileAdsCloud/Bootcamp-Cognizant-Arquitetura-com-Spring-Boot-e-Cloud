package edu.prj.designpatterns.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.prj.designpatterns.model.User;
import edu.prj.designpatterns.model.dto.LoginRecordRequest;
import edu.prj.designpatterns.model.dto.SessaoRecord;
import edu.prj.designpatterns.repository.UserRepository;
import edu.prj.designpatterns.security.JWTCreator;
import edu.prj.designpatterns.security.JWTObject;
import edu.prj.designpatterns.security.SecurityConfig;

/**
 * @author Adriano Aparecido da Silva
 *         <p>
 *         Controller LoginController: Esta classe terá o recurso de realizar o
 *         login e geração do token.
 */

@RestController
public class LoginController {
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private UserRepository repository;

	@PostMapping("/login")
	public SessaoRecord logar(@RequestBody LoginRecordRequest login) {

		User user = repository.findByUsername(login.username());

		if (user != null) {
			boolean passwordOk = encoder.matches(login.password(), user.getPassword());
			if (!passwordOk) {
				throw new RuntimeException("Senha inválida para o login: " + login.username());
			}
			// Estamos enviando um objeto Sessão para retornar mais informações do usuário

			JWTObject jwtObject = new JWTObject();
			jwtObject.setIssuedAt(new Date(System.currentTimeMillis()));
			jwtObject.setExpiration((new Date(System.currentTimeMillis() + SecurityConfig.EXPIRATION)));
			jwtObject.setRoles(user.getRoles());
			SessaoRecord sessao = new SessaoRecord(user.getUsername(),
					JWTCreator.create(SecurityConfig.PREFIX, SecurityConfig.KEY, jwtObject));

			return sessao;
		} else {
			throw new RuntimeException("Erro ao tentar fazer login");
		}
	}
}
