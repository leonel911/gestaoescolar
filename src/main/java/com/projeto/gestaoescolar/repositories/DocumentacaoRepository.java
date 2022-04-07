package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Documentacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentacaoRepository extends JpaRepository<Documentacao, Integer> {

    Documentacao findDocumentacaoById(Integer id);
}
