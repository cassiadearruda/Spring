package farmaciavida.FarmaciaVida.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import farmaciavida.FarmaciaVida.entity.ProdutoEntity;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {
	
	public List<ProdutoEntity> findAllByNomeContainingIgnoreCase (String nome);
}
