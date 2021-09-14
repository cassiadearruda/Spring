package org.generation.demeterAPI.controller;

import java.util.List;
import java.util.Optional;

import org.generation.demeterAPI.model.UserLogin;
import org.generation.demeterAPI.model.Usuario;
import org.generation.demeterAPI.repository.UsuarioRepository;
import org.generation.demeterAPI.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController					//Anotação para declarar que é uma API Rest
@RequestMapping("/usuario")		//Anotação para indicar qual o endereço do Mapping
@CrossOrigin("*")				//Anotação para indicar que recebe informações de diversas origens
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping								//Mapping da função GET -> Retorna todas as entradas no Banco de Dados
	public ResponseEntity <List<Usuario>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")					//Mapping da Função GET BY ID -> Retorna a entrada de acordo com o ID indicado na URL
	public ResponseEntity <Usuario> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")	//Mapping da Função GET BY categoria -> Retorna a entrada de acordo com a categoria na URL
	public ResponseEntity <List<Usuario>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@GetMapping("/email/{email}")	//Mapping da Função GET BY categoria -> Retorna a entrada de acordo com a categoria na URL
	public ResponseEntity <List<Usuario>> GetByEmail(@PathVariable String email){
		return ResponseEntity.ok(repository.findAllByEmailContainingIgnoreCase(email));
	}
	
	/*@PostMapping							//Mapping da Função POST -> Cria a entrada no Banco de Dados
	public ResponseEntity <Usuario> Post (@RequestBody Usuario usuario){ // -> Envia dados via Body da requisição http por JSON
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}*/
	
	@PutMapping							//Mapping da Função POST -> Cria a entrada no Banco de Dados
	public ResponseEntity <Usuario> Put (@RequestBody Usuario usuario){ // -> Envia dados via Body da requisição http por JSON
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(usuario));
	}
	
	@DeleteMapping("/{id}")					//Mapping da Função DELETE -> Deleta uma entrada no banco de dados 
	public void Delete (@PathVariable long id) { // -> Envia dados via URL
		repository.deleteById(id);
	}
	
	
	@PostMapping("/logar")
	public ResponseEntity<UserLogin> Autentication(@RequestBody Optional<UserLogin> user) {
		return usuarioService.Logar(user)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
	}

	@PostMapping("/cadastrar")
	public ResponseEntity<Usuario> Post(@RequestBody Usuario usuario) {
		return usuarioService.CadastrarUsuario(usuario)
				.map(resp -> ResponseEntity.status(HttpStatus.CREATED).body(resp))
				.orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
	}
	
}
