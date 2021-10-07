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

import br.org.generation.minhaLojaDeGames.model.categoria;
import br.org.generation.minhaLojaDeGames.repository.CategoriaRepository;

@RestController
@RequestMapping ("/categoria")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repositoty;
	
	@GetMapping
	public ResponseEntity<List<categoria>> GetAll (){
		return ResponseEntity.ok(repositoty.findAll());
		
	}

	@GetMapping("/(id)")
	public ResponseEntity<categoria> GetById(@PathVariable long id){
		return repositoty.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/nome(nome)")
	public ResponseEntity <List<categoria>> GetByNome(@PathVariable String nome){
		return ResponseEntity.ok(repositoty.findAllByNomeContainingIgnoreCase(nome));
		
	}
	@PostMapping
	public ResponseEntity<categoria> post (@RequestBody categoria categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(categoria));
		
	}
	@PutMapping
	public ResponseEntity<categoria> put (@RequestBody categoria categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(categoria));
	}
	
	@DeleteMapping ("/{id}")
	public void delete(@PathVariable long id){
		repositoty.deleteById(id);
	}
	
	


}


