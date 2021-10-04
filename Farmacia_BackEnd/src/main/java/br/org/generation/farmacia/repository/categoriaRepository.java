package br.org.generation.farmacia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.generation.farmacia.model.categoria;


public interface categoriaRepository extends JpaRepository<categoria, Long> {

	public List<categoria> findAllByMedicamentoContainigIgnoreCase (String medicamento);
	
}
