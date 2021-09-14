package org.generation.blogPessoal.controller;

import java.util.List;
import java.util.Optional;
import org.generation.blogPessoal.entity.UserLoginEntity;
import org.generation.blogPessoal.entity.UsuarioEntity;
import org.generation.blogPessoal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/all")
	public ResponseEntity <List<UsuarioEntity>> getAll(){
		
		return ResponseEntity.ok(usuarioService.listarUsuarios());
		
	}

	@PostMapping("/logar")
	public ResponseEntity<UserLoginEntity> autentication(@RequestBody Optional<UserLoginEntity> user) {
		return usuarioService.Logar(user).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<UsuarioEntity> post(@RequestBody UsuarioEntity usuario){
		return usuarioService.CadastrarUsuario(usuario).map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<UsuarioEntity> putUsuario(@RequestBody UsuarioEntity usuario){
		
		return usuarioService.atualizarUsuario(usuario)
			.map(resp -> ResponseEntity.status(HttpStatus.OK).body(resp))
			.orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
	}
}