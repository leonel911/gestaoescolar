package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Usuario;
import com.projeto.gestaoescolar.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ImplUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuario = usuarioRepository.findByUsername(username);
        if (!usuario.isPresent()) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Usuário não encontrado!");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();

        return new User(
                usuario.get().getUsername(),
                usuario.get().getSenha(),
                true,
                true,
                true,
                true,
                authorities);

    }

}
