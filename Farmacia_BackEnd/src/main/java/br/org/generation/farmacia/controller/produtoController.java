package br.org.generation.farmacia.controller;

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

import br.org.generation.farmacia.model.produto;

@RestController
@RequestMapping("/produto")
@CrossOrigin(origins "*", allowedHeaders = "*")
public class produtoController {
	
	@Autowired
    produto repository;

	public ResponseEntity <List<produto>> getAllProduto(){
		return ResponseEntity.ok(repository.findAll());
	}

	
	@GetMapping("/{id}")
	public ReponseEntity<produto> getAllProdutoBy(@PathVariable("id")long id){
		return repository.findById(id)
		.map(resposta -> ResponseEntity.OK(resposta))
		.orElse(ResponseEntity.notFound().build());	
	}
	@GetMapping("/filter/{produto}")
	public ResponseEntity<List<produto>> getAllProdutofilter(@PathVariable("produto")String produto){
		return ResponseEntity.OK(repository.findAllByDescricaoContainingIgnoreCas(produto));
	}
	@PostMapping
	public ResponseEntity<produto> postProduto(@RequestBody produto produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}
	@PutMapping
	public ResponseEntity<produto> putProduto(@RequestBody produto produto){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
	}
    @DeleteMapping("/delete/{id}")
    public void deleteProduto(@PathVariable("id")long id) {
    	repository.deleteById(id);
    }
}
