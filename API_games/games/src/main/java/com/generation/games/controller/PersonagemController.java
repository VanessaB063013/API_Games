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

import com.generation.games.Repository.PersonagemRepository;
import com.generation.games.model.Personagem;

@RestController
@RequestMapping("personagem")
@CrossOrigin(origins ="*", allowedHeaders="*")
public class PersonagemController {
	
	@Autowired
	private PersonagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Personagem>> getall(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Personagem> getById(@PathVariable long id){
		return repository.findById(id).map(resp-> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());	
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<Personagem>> getByTipo(@PathVariable String nome ){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
		}
	
	@PostMapping
	public ResponseEntity<Personagem> post (@RequestBody Personagem personagem){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(personagem));
		
	}
	
	@PutMapping
	public ResponseEntity<Personagem> put (@RequestBody Personagem personagem){
		return ResponseEntity.ok(repository.save(personagem));
		
	}
	
	@DeleteMapping
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}

}
