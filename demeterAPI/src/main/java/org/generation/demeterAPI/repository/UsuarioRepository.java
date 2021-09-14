package org.generation.demeterAPI.repository;

import java.util.List;
import java.util.Optional;

import org.generation.demeterAPI.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	public List<Usuario> findAllByNomeContainingIgnoreCase(String nome);
	public List<Usuario> findAllByEmailContainingIgnoreCase(String email);
	public Optional<Usuario> findByEmail(String email);
}
