package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Unidade;
import com.projeto.gestaoescolar.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Unidade create(Unidade unidade) {
            return unidadeRepository.save(unidade);
    }

    public Unidade findById(Integer id) {
        return unidadeRepository.findUnidadeById(id);
    }


    public List<Unidade> findAll() {
            return unidadeRepository.findAll();
        }

    public Unidade update(Unidade unidade) {
        Unidade newUnidade = findById(unidade.getId());

        if(unidade.getNome() == null) {
            newUnidade.setNome(newUnidade.getNome());
    }   else {
            newUnidade.setNome(unidade.getNome());
        }
        if(unidade.getEndereço() == null) {
            newUnidade.setEndereço(unidade.getEndereço());
        }
        if(unidade.getTelefone() == null) {
            newUnidade.setTelefone((unidade.getTelefone()));
        }
        if(unidade.getCoordenador() == null) {
            newUnidade.setCoordenador(unidade.getCoordenador());
        }
        return unidadeRepository.save(newUnidade);
        }

    public void delete(Integer id) {
        unidadeRepository.deleteById(id);
    }
}
