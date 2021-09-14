/* Controlador REST para a Classe Tema
 * API Demeter Grupo 06 Turma 30 Generation Brasil
 * 
 * Integrantes
 *	Anderson Coelho
 *	Cássia Arruda
 *	Matheus Farina
 *	Renata Ferreira
 *	Vini Cardoso
 */

package org.generation.demeterAPI.controller;

import java.util.List;

import org.generation.demeterAPI.model.Tema;
import org.generation.demeterAPI.repository.TemaRepository;
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
@RequestMapping("/tema")		//Anotação para indicar qual o endereço do Mapping
@CrossOrigin("*")				//Anotação para indicar que recebe informações de diversas origens
public class TemaController {
	
	@Autowired
	private TemaRepository repository;		//Criação do Repositório e entrega para a JPA fazer o gerenciamento
	
	@GetMapping								//Mapping da função GET -> Retorna todas as entradas no Banco de Dados
	public ResponseEntity <List<Tema>> GetAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")					//Mapping da Função GET BY ID -> Retorna a entrada de acordo com o ID indicado na URL
	public ResponseEntity <Tema> GetById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).
				orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/categoria/{categoria}")	//Mapping da Função GET BY categoria -> Retorna a entrada de acordo com a categoria na URL
	public ResponseEntity <List<Tema>> GetByCategoria(@PathVariable String categoria){
		return ResponseEntity.ok(repository.findAllByCategoriaContainingIgnoreCase(categoria));
	}
	
	@GetMapping("/filtro/{filtro}")			//Mapping da Função GET BY filtro -> Retorna a entrada de acordo com a filtro na URL
	public ResponseEntity <List<Tema>> GetByFiltro(@PathVariable String filtro){
		return ResponseEntity.ok(repository.findAllByFiltroContainingIgnoreCase(filtro));
	}

	@GetMapping("/localidade/{localidade}")	//Mapping da Função GET BY localidade -> Retorna a entrada de acordo com a localidade na URL
	public ResponseEntity <List<Tema>> GetByLocalidade(@PathVariable String localidade){
		return ResponseEntity.ok(repository.findAllByLocalidadeContainingIgnoreCase(localidade));
	}
	
	@PostMapping							//Mapping da Função POST -> Cria a entrada no Banco de Dados
	public ResponseEntity <Tema> Post (@RequestBody Tema tema){ // -> Envia dados via Body da requisição http por JSON
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(tema));
	}
	
	@PutMapping								//Mapping da Função PUT -> Atualiza uma entrada no banco de Dados
	public ResponseEntity <Tema> Put (@RequestBody Tema tema){ // -> Envia dados via Body da requisição http por JSON
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(tema));
	}
	
	@DeleteMapping("/{id}")					//Mapping da Função DELETE -> Deleta uma entrada no banco de dados 
	public void Delete (@PathVariable long id) { // -> Envia dados via URL
		repository.deleteById(id);
	}
}
