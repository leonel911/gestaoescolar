package com.projeto.gestaoescolar.repositories;

import com.projeto.gestaoescolar.domain.Aluno;
import com.projeto.gestaoescolar.domain.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationToken, Integer> {

    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
