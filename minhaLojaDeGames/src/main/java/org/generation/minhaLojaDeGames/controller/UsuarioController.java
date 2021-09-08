package org.generation.minhaLojaDeGames.controller;

import java.util.Optional;
import org.generation.minhaLojaDeGames.entity.UserLoginEntity;
import org.generation.minhaLojaDeGames.entity.UsuarioEntity;
import org.generation.minhaLojaDeGames.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/logar")
	public ResponseEntity<UserLoginEntity> Autentication(@RequestBody Optional<UserLoginEntity> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioEntity> Post(@RequestBody UsuarioEntity usuario){
		return usuarioService.CadastrarUsuario(usuario).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
	}
}