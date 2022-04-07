package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Responsavel;
import com.projeto.gestaoescolar.repositories.ResponsavelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsavelService {

    @Autowired
    public ResponsavelRepository responsavelRepository;

    public Responsavel create(Responsavel responsavel) {
        return responsavelRepository.save(responsavel);
    }

    public Responsavel findResponsavelById(Integer id) {
        return responsavelRepository.findResponsavelById(id);
    }

    public List<Responsavel> findAll() {
        return responsavelRepository.findAll();
    }

    public Responsavel update(Responsavel responsavel) {
        Responsavel newReponsavel = findResponsavelById(responsavel.getId());

        if(responsavel.getNome() == null) {
            responsavel.setNome(newReponsavel.getNome());
        } else {
            newReponsavel.setNome(responsavel.getNome());
        }

        if(responsavel.getTelefones() == null) {
            responsavel.setTelefones(newReponsavel.getTelefones());
        } else {
            newReponsavel.setTelefones(responsavel.getTelefones());
        }

        if(responsavel.getDataNascimento() == null) {
            responsavel.setDataNascimento(newReponsavel.getDataNascimento());
        } else {
            newReponsavel.setDataNascimento(responsavel.getDataNascimento());
        }

        if(responsavel.getNisResponsavel() == null) {
            responsavel.setNisResponsavel(newReponsavel.getNisResponsavel());
        } else {
            newReponsavel.setNisResponsavel(responsavel.getNisResponsavel());
        }

        if(responsavel.getEmail() == null) {
            responsavel.setEmail(newReponsavel.getEmail());
        } else {
            newReponsavel.setEmail(responsavel.getEmail());
        }

        if(responsavel.getObservacao() == null) {
            responsavel.setObservacao(newReponsavel.getObservacao());
        } else {
            newReponsavel.setObservacao(responsavel.getObservacao());
        }

        return responsavel;
    }


    public void delete(Integer id) {
        responsavelRepository.deleteById(id);
    }
}
