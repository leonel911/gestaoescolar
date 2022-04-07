package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Endereco;
import com.projeto.gestaoescolar.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco create(Endereco endereco) {
        return enderecoRepository.save(endereco);
    }


    public Endereco findEnderecoById(Integer id) {
        return enderecoRepository.findEnderecoById(id);
    }

    public List<Endereco> findAll() {
        return enderecoRepository.findAll();
    }

    public Endereco update(Endereco endereco) {
        Endereco newEndereco = findEnderecoById(endereco.getId());

        if(endereco.getLogradouro() == null) {
            endereco.setLogradouro(newEndereco.getLogradouro());
        } else {
            newEndereco.setLogradouro(endereco.getLogradouro());
        }

        if(endereco.getNumero() == null) {
            endereco.setNumero(newEndereco.getNumero());
        } else {
            newEndereco.setNumero(endereco.getNumero());
        }

        if(endereco.getCep() == null) {
            endereco.setCep(newEndereco.getCep());
        } else {
            newEndereco.setCep(endereco.getCep());
        }

        if(endereco.getBairro() == null) {
            endereco.setBairro(newEndereco.getBairro());
        } else {
            newEndereco.setBairro(endereco.getBairro());
        }

        if(endereco.getCidade() == null) {
            endereco.setCidade(newEndereco.getCidade());
        } else {
            newEndereco.setCidade(endereco.getCidade());
        }

        if(endereco.getEstado() == null) {
            endereco.setEstado(newEndereco.getEstado());
        } else {
            newEndereco.setEstado(endereco.getEstado());
        }

        if(endereco.getResponsavel() == null) {
            endereco.setResponsavel(newEndereco.getResponsavel());
        } else {
            newEndereco.setResponsavel(endereco.getResponsavel());
        }

        if(endereco.getUnidade() == null) {
            endereco.setUnidade(newEndereco.getUnidade());
        } else {
            newEndereco.setUnidade(endereco.getUnidade());
        }

        return endereco;

    }

    public void delete(Integer id) {
        enderecoRepository.deleteById(id);
    }
}
