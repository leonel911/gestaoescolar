package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Coordenador;
import com.projeto.gestaoescolar.repositories.CoordenadorRepository;
import com.projeto.gestaoescolar.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImplUserDetailService implements UserDetailsService {

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<Coordenador> coordenador = coordenadorRepository.findCoordenadorByUsername(username);
        if (!coordenador.isPresent()) {
            throw new ObjectNotFoundException("Usuário não encontrado");
        }

        List<GrantedAuthority> authorities = new ArrayList<>();


        return new User(
                coordenador.get().getUsername(),
                coordenador.get().getSenha(),
                true,
                true,
                true,
                true,
                authorities
        );

    }
}
