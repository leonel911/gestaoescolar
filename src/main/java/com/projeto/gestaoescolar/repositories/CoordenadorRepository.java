package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Coordenador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordenadorRepository extends JpaRepository<Coordenador, Integer> {

    Coordenador findCoordenadorById(Integer id);

}
