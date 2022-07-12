package com.generation.games.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.games.model.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long> {

	public List<Personagem>findAllByNomeContainingIgnoreCase(String nome);
}
