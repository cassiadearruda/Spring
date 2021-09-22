package farmaciavida.FarmaciaVida.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import farmaciavida.FarmaciaVida.entity.CategoriaEntity;

public interface CategoriaRepository extends JpaRepository <CategoriaEntity, Long>{
	
	public List<CategoriaEntity> findAllByDescricaoContainingIgnoreCase(String descricao);
}
