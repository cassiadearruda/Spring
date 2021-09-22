package farmaciavida.FarmaciaVida.controller;

import java.util.List;

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

import farmaciavida.FarmaciaVida.entity.ProdutoEntity;
import farmaciavida.FarmaciaVida.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<ProdutoEntity>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoEntity> GetByIdProduto (@PathVariable long id) {
		return repository.findById(id)
				.map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoEntity>> GetByNomeProduto (@PathVariable String nome) {
			return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	@PostMapping
	public ResponseEntity<ProdutoEntity> Post (@RequestBody ProdutoEntity produto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto)); 
	}
	
	@PutMapping
	public ResponseEntity<ProdutoEntity> Put (@RequestBody ProdutoEntity produto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto)); 
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}
}
