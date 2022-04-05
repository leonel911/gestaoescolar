package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer> {

    Unidade findUnidadeById(Integer id);
    Unidade findUnidadeByCodigoUnidade(Integer codigoUnidade);

}
