package com.generation.games.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.games.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
	public Optional<Usuario> findByUsuario (String usuario);

}
