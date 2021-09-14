/* Repository para a Classe Tema
 * API Demeter Grupo 06 Turma 30 Generation Brasil
 * 
 * Integrantes
 *	Anderson Coelho
 *	Cássia Arruda
 *	Matheus Farina
 *	Renata Ferreira
 *	Vini Cardoso
 */
package org.generation.demeterAPI.repository;

import java.util.List;
import org.generation.demeterAPI.model.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemaRepository extends JpaRepository<Tema, Long> {
	
	public List<Tema> findAllByCategoriaContainingIgnoreCase(String categoria); // -> Find by Categoria, encontra as
																				// entradas pela Categoria e ignora
																				// maiusculas e minusculas

	public List<Tema> findAllByFiltroContainingIgnoreCase(String filtro); // -> Find by Filtro, encontra as entradas
																			// pelo Filtro e ignora maiusculas e
																			// minusculas

	public List<Tema> findAllByLocalidadeContainingIgnoreCase(String localidade); // -> Find by Localidade, encontra as
																					// entradas pela Localidade e ignora
																					// maiusculas e minusculas
}
