package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Responsavel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsavelRepository extends JpaRepository<Responsavel, Integer> {
    Responsavel findResponsavelById(Integer id);
}
