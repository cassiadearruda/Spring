package org.generation.blogPessoal.repository;

import java.util.List;
import org.generation.blogPessoal.entity.PostagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostagemRepository extends JpaRepository<PostagemEntity, Long> {
	
	public List<PostagemEntity> findAllByTituloContainingIgnoreCase (String titulo);
	
}
