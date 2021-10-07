package br.org.generation.minhaLojaDeGames.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import br.org.generation.minhaLojaDeGames.model.produto;

public interface produtorepository extends JpaRepository<produto, Long> {


public List<produto> findByAllProdutosContainingIgnoreCase(String produto);
	
	@Query(value = "select id, preco, data, produto, estoqueproduto, categoriaid from tb_produto where estoqueproduto > 0", nativeQuery = true)
	public  List<produto> findByAllProdutoEstoqueDisponivel();
	
	@Query(value = "select id, preco, data, produto, estoqueproduto, categoriaid from tb_produto where estoqueproduto <= 0", nativeQuery = true)
	public  List<produto> findByAllProdutoEstoqueIndisponivel();

	public Object findAllByProdutoContainingIgnoreCase(String produto);


}
