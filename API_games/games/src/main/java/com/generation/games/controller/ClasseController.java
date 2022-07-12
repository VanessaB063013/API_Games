package com.generation.games.controller;

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

import com.generation.games.Repository.ClasseRepository;
import com.generation.games.model.Classe;

@RestController
@RequestMapping("classe")
@CrossOrigin(origins ="*", allowedHeaders="*")
public class ClasseController {
	
	@Autowired
	private ClasseRepository repository; 
	
	@GetMapping
	public ResponseEntity<List<Classe>> getall(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Classe> getById(@PathVariable long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/nameClass/{nameClass}")
	public ResponseEntity<List<Classe>> getByTipo(@PathVariable String nameclass ){
		return ResponseEntity.ok(repository.findAllByClassNameContainingIgnoreCase(nameclass));
		}
	
	
	@PostMapping
	public ResponseEntity<Classe> post (@RequestBody Classe classe){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(classe));
		}
	
	
	@PutMapping
	public ResponseEntity<Classe> put (@RequestBody Classe classe){
		return ResponseEntity.ok(repository.save(classe));
		
	}
	
	@DeleteMapping
	public void delete(@PathVariable long id) {
		repository.deleteById(id);}


}
	
	
	
	
	
	
	
	


