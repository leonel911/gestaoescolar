package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Aluno;
import com.projeto.gestaoescolar.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    Endereco findEnderecoById(Integer id);
}
