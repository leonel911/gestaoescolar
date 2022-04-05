package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    Aluno findAlunoById(Integer id);
}
