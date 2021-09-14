package org.generation.demeterAPI.repository;

import java.util.List;
import org.generation.demeterAPI.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository <Postagem, Long>{
	
	public List<Postagem> findAllByTituloContainingIgnoreCase(String titulo);
	public List<Postagem> findAllByAtivo(Boolean ativo);
	//public List<Postagem> findAllByData(String data);
}
