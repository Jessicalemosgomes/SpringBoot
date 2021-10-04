package br.org.generation.farmacia.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.org.generation.farmacia.model.produto;


public interface produtoRepository extends JpaRepository<produto, Long> {
	
	public List<produto> findAllByDescricaoContainingIgnoreCase(String descricao);{

}
