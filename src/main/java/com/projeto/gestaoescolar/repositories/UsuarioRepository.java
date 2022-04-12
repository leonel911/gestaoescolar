package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Coordenador;
import com.projeto.gestaoescolar.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {


    Optional<Usuario> findByUsername(String username);
}
