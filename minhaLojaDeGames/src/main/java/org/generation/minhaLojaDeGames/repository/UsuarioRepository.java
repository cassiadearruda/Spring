package org.generation.minhaLojaDeGames.repository;

import java.util.Optional;
import org.generation.minhaLojaDeGames.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

	public Optional<UsuarioEntity> findByUsuario(String usuario);
}
