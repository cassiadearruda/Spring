package org.generation.farmacia.repository;

import java.util.List;

import org.generation.farmacia.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
	
	public List<ProdutoEntity> findAllByNomeContainingIgnoreCase (String nome);
}
