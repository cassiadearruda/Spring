package org.generation.demeterAPI.controller;

import java.util.List;
import org.generation.demeterAPI.model.Postagem;
import org.generation.demeterAPI.repository.PostagemRepository;
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
@RequestMapping("/postagem")		//Anotação para indicar qual o endereço do Mapping
@CrossOrigin("*")				//Anotação para indicar que recebe informações de diversas origens
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;
	
	@GetMapping								//Mapping da função GET -> Retorna todas as entradas no Banco de Dados
	public ResponseEntity <List<Postagem>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")					//Mapping da Função GET BY ID -> Retorna a entrada de acordo com o ID indicado na URL
	public ResponseEntity <Postagem> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")	//Mapping da Função GET BY categoria -> Retorna a entrada de acordo com a categoria na URL
	public ResponseEntity <List<Postagem>> GetByTitulo(@PathVariable String titulo){
		return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo));
	}
	
	@GetMapping("/status/{ativo}")
	public ResponseEntity <List<Postagem>> GetByAtivo(@PathVariable boolean ativo){
		return ResponseEntity.ok(repository.findAllByAtivo(ativo));
	}
	
	/*@GetMapping("/data/{data}")	//Mapping da Função GET BY categoria -> Retorna a entrada de acordo com a categoria na URL
	public ResponseEntity <List<Postagem>> GetByData(@PathVariable String data){
		return ResponseEntity.ok(repository.findAllByData(data));
	}*/
	
	@PostMapping							//Mapping da Função POST -> Cria a entrada no Banco de Dados
	public ResponseEntity <Postagem> Post (@RequestBody Postagem postagem){ // -> Envia dados via Body da requisição http por JSON
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@PutMapping							//Mapping da Função POST -> Cria a entrada no Banco de Dados
	public ResponseEntity <Postagem> Put (@RequestBody Postagem postagem){ // -> Envia dados via Body da requisição http por JSON
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
	}
	
	@DeleteMapping("/{id}")					//Mapping da Função DELETE -> Deleta uma entrada no banco de dados 
	public void Delete (@PathVariable long id) { // -> Envia dados via URL
		repository.deleteById(id);
	}
}
