package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Escola;
import com.projeto.gestaoescolar.repositories.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaService {

    @Autowired
    private EscolaRepository escolaRepository;

    public Escola create(Escola escola) {
        return escolaRepository.save(escola);
    }


    public Escola findEscolaById(Integer id) {
        return escolaRepository.findEscolaById(id);
    }

    public List<Escola> findAll() {
        return escolaRepository.findAll();
    }

    public Escola update(Escola escola) {
        Escola newEscola = findEscolaById(escola.getId());

        if(escola.getNome() == null) {
            escola.setNome(newEscola.getNome());
        } else {
            newEscola.setNome(escola.getNome());
        }

        if(escola.getNome() == null) {
            escola.setNome(newEscola.getNome());
        } else {
            newEscola.setNome(escola.getNome());
        }

        if(escola.getAlunos() == null) {
            escola.setAlunos(newEscola.getAlunos());
        } else {
            newEscola.setAlunos(escola.getAlunos());
        }

        if(escola.getEndereco() == null) {
            escola.setEndereco(newEscola.getEndereco());
        } else {
            newEscola.setEndereco(escola.getEndereco());
        }

        return escola;

    }

    public void delete(Integer id) {
        escolaRepository.deleteById(id);
    }
}
