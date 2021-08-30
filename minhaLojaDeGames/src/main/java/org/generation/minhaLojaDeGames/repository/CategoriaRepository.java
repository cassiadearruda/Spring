package org.generation.minhaLojaDeGames.repository;

import java.util.List;

import org.generation.minhaLojaDeGames.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <CategoriaEntity, Long>{
		
	public List<CategoriaEntity> findAllByDescricaoContainingIgnoreCase(String descricao);
}

