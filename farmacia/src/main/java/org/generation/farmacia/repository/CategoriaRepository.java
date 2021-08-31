package org.generation.farmacia.repository;

import java.util.List;
import org.generation.farmacia.entity.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <CategoriaEntity, Long>{
	
	public List<CategoriaEntity> findAllByDescricaoContainingIgnoreCase(String descricao);
}
