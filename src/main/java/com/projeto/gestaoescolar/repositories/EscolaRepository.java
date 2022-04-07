package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Escola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<Escola, Integer> {

    Escola findEscolaById(Integer id);
}
