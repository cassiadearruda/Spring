package org.generation.blogPessoal.repository;

import java.util.List;

import org.generation.blogPessoal.entity.TemaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<TemaEntity, Long>{
	
	public List<TemaEntity> findAllByDescricaoContainingIgnoreCase(String descricao); 
}
