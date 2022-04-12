package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.ConfirmationToken;
import com.projeto.gestaoescolar.domain.Coordenador;
import com.projeto.gestaoescolar.domain.Unidade;
import com.projeto.gestaoescolar.domain.Usuario;
import com.projeto.gestaoescolar.repositories.ConfirmationTokenRepository;
import com.projeto.gestaoescolar.repositories.CoordenadorRepository;
import com.projeto.gestaoescolar.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Service
public class CoordenadorService {

    @Autowired
    private PasswordEncoder pe;

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    public Coordenador create(Coordenador coordenador) {
        coordenador.setAccountActivated(true);
        coordenador.setSenha(pe.encode(coordenador.getSenha()));
        Unidade unidade = unidadeRepository.findUnidadeByCodigoUnidade(coordenador.getCodigoUnidade());
        coordenador.setUnidade(unidade);
        unidade.setCoordenador(coordenador);
        coordenadorRepository.save(coordenador);
        ConfirmationToken confirmationToken = new ConfirmationToken(coordenador);
        confirmationToken.setCoordenador(coordenador);
        coordenador.setConfirmationToken(confirmationToken);
        confirmationTokenRepository.save(confirmationToken);
        unidadeRepository.save(unidade);
        return coordenador;
    }

    public Coordenador findById(Integer id) {
        return coordenadorRepository.findCoordenadorById(id);
    }

    public List<Coordenador> findAll() {
        return coordenadorRepository.findAll();
    }

    public Coordenador update(Coordenador coordenador) {
        Coordenador newCoordenador = findById(coordenador.getId());
        if (coordenador.getNome() == null) {
            coordenador.setNome(newCoordenador.getNome());
        } else {
            newCoordenador.setNome(coordenador.getNome());
        }
        if (coordenador.getUsername() == null) {
            coordenador.setUsername(newCoordenador.getUsername());
        } else {
            newCoordenador.setUsername(coordenador.getUsername());
        }
        if (coordenador.getSenha() == null) {
            coordenador.setSenha(newCoordenador.getSenha());
        } else {
            newCoordenador.setSenha(coordenador.getSenha());
        }
        if (coordenador.getEmail() == null) {
            coordenador.setEmail(newCoordenador.getEmail());
        } else {
            newCoordenador.setEmail(coordenador.getEmail());
        }

        return coordenadorRepository.save(newCoordenador);
    }

    public void delete(Integer id) {
        coordenadorRepository.deleteById(id);

    }
    public Coordenador toCoordenadorModel(Coordenador novoCoordenador) {
        Coordenador coordenador = new Coordenador(novoCoordenador.getId(), novoCoordenador.getNome(), novoCoordenador.getUsername(),
                novoCoordenador.getSenha(), novoCoordenador.getEmail(), novoCoordenador.getCodigoUnidade());
        coordenador.setUsuario(toUsuario(novoCoordenador));
        coordenador.setSenha(pe.encode(novoCoordenador.getSenha()));
        return coordenador;


    }
    public Usuario toUsuario(Coordenador novoCoordenador){
        return new Usuario(novoCoordenador.getId(), novoCoordenador.getUsername(), pe.encode(novoCoordenador.getSenha()));
    }

}
