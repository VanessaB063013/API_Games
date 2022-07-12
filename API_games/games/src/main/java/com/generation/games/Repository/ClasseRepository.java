package com.generation.games.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.games.model.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Long>{
	public List<Classe>findAllByClassNameContainingIgnoreCase(String classname);

}
