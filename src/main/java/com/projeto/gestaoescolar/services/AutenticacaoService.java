package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.AutenticacaoDto;
import com.projeto.gestaoescolar.domain.Coordenador;
import com.projeto.gestaoescolar.domain.DadosLogin;
import com.projeto.gestaoescolar.domain.Usuario;
import com.projeto.gestaoescolar.repositories.CoordenadorRepository;
import com.projeto.gestaoescolar.repositories.UsuarioRepository;
import com.projeto.gestaoescolar.resources.exceptions.InvalidLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ImplUserDetailService implUserDetailService;

    public AutenticacaoDto doLogin(DadosLogin dadosLogin){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(dadosLogin.getUsername(), dadosLogin.getSenha());
        try {
            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        }catch (Exception exception){
            throw new InvalidLoginException("Usuário e/ou senha inválido");
        }
        Optional<Usuario> usuario = usuarioRepository.findByUsername(dadosLogin.getUsername());
        UserDetails userDetails = implUserDetailService.loadUserByUsername(dadosLogin.getUsername());
        String token = tokenService.generateToken(userDetails, usuario.get());
        return new AutenticacaoDto(token, "Bearer");
    }
}
