package com.projeto.gestaoescolar.config;

import com.projeto.gestaoescolar.domain.Usuario;
import com.projeto.gestaoescolar.repositories.UsuarioRepository;
import com.projeto.gestaoescolar.resources.exceptions.InvalidLoginException;
import com.projeto.gestaoescolar.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public AuthTokenFilter(TokenService tokenService, UsuarioRepository usuarioRepository) {
        this.tokenService = tokenService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String token = recuperarToken(request);
        boolean valido = tokenService.isValid(token);
        if (valido){
            Integer userId = authCliente(token);
            request.setAttribute("id", userId);
        }
        filterChain.doFilter(request, response);
    }

    private Integer authCliente(String token) {
        Integer userId = tokenService.getUserId(token);
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(userId);
        if(!optionalUsuario.isPresent()){
            throw new InvalidLoginException("Usuário não encontrado!");
        }
        UsernamePasswordAuthenticationToken authentication =
                new UsernamePasswordAuthenticationToken(optionalUsuario.get().getUsername(),
                        optionalUsuario.get().getSenha(),
                        Collections.singletonList(new SimpleGrantedAuthority(optionalUsuario.get().getPerfil()
                        .getDescricao()))
                        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return userId;
    }

    private String recuperarToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer")){
            return null;
        }
        return token.substring(7, token.length());
    }
}
