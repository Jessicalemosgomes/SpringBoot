package br.org.generation.minhaLojaDeGames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.generation.minhaLojaDeGames.model.categoria;

public interface CategoriaRepository extends JpaRepository<categoria, Long>{

	public List<categoria> findAllByNomeContainingIgnoreCase (String nome);
}
