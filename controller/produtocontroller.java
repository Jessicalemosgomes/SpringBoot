package br.org.generation.minhaLojaDeGames.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.org.generation.minhaLojaDeGames.model.produto;
import br.org.generation.minhaLojaDeGames.repository.produtorepository;


public class produtocontroller {
	
	@Autowired
	produtorepository repository;

	
	@GetMapping
	public ResponseEntity<List<produto>> getAllProdutos(){		
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/estoque/positivo")
	public ResponseEntity<List<produto>> getProdutosEstoquePositivo(){
		return ResponseEntity.ok(repository.findByAllProdutosEstoqueDisponivel());
	}
	
	@GetMapping("/estoque/negativo")
	public ResponseEntity<List<produto>> getProdutosEstoqueNegativo(){
		return ResponseEntity.ok(repository.findByAllProdutosEstoqueIndisponivel());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<produto> getProdutoById(@PathVariable("id") long id){
		return repository.findById(id)
			   .map(resposta -> ResponseEntity.ok(resposta))
			   .orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/filter/{produto}")
	public ResponseEntity<List<produto>> getAllProdutoContaining(@PathVariable("produto") String produto){
		return ResponseEntity.ok(repository.findAllByProdutoContainingIgnoreCase(produto));
	}
	
	@PostMapping
	public ResponseEntity<produto> postProduto(@RequestBody produto model){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(model));
	}
	
	@PutMapping
	public ResponseEntity<produto> putProduto(@RequestBody produto model){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(model));
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduto(@PathVariable("id") long id) {
		repository.deleteById(id);
	}

}
