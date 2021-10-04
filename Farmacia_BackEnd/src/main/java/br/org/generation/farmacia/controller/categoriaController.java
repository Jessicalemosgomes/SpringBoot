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
import br.org.generation.farmacia.model.categoria;
import br.org.generation.farmacia.repository.categoriaRepository;


@RestController
@RequestMapping ("/categoria")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class categoriaController {
	
	@Autowired
	private categoriaRepository repository;

	@GetMapping
	public ResponseEntity<List<categoria>> getAllCategoria(){
		return ResponseEntity.ok(repository.findAll());
	}
	@GetMapping("/filter{medicamento}")
	public ResponseEntity<List<categoria>> getAllfiterMedicamento(@PathVariable("medicamentos")String medicamento){
		return ResponseEntity.ok(repository.findAllByMedicamentoContainigIgnoreCase(medicamento));
	}
    
	@GetMapping("/{id}")
    public ResponseEntity<categoria> getByIdcategoria(@PathVariable("id")long id){
    	return repository.findById(id)
    			.map(resposta -> ResponseEntity.ok(resposta))
    			.orElse(ResponseEntity.notFound().build());
     }
    
    @PostMapping
    public ResponseEntity<categoria> postCategoria(@RequestBody categoria categoria){
    	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categoria));
    }

    @PutMapping
    public ResponseEntity<categoria> putcategoria(@RequestBody categoria categoria){
    	return ResponseEntity.status(HttpStatus.OK).body(repository.save(categoria));
    }

    @DeleteMapping("/{id}")
    public void deletecategoria(@PathVariable("id")long id) {
    	repository.deleteById(id);
    }
    
}
























}
