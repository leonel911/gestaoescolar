package com.projeto.gestaoescolar.config;

import com.projeto.gestaoescolar.domain.Coordenador;
import com.projeto.gestaoescolar.repositories.CoordenadorRepository;
import com.projeto.gestaoescolar.resources.exceptions.InvalidLoginException;
import com.projeto.gestaoescolar.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
public class AuthTokenFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    public AuthTokenFilter(TokenService tokenService, CoordenadorRepository coordenadorRepository) {
        this.tokenService = tokenService;
        this.coordenadorRepository = coordenadorRepository;
    }

    private Integer authClient(String token) {
        Integer userId = tokenService.getUserId(token);
        Optional<Coordenador> optionalCoordenador = coordenadorRepository.findById(userId);
        if (!optionalCoordenador.isPresent()) {
            throw new InvalidLoginException("Usuário não encontrado");
        }
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(optionalCoordenador.get().getUsername(),
                        optionalCoordenador.get().getSenha()
                );
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        return userId;
    }

    private String recuperaToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        if (token == null || !token.startsWith("Bearer")) {
            return null;
        }
        return token.substring(7, token.length());
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = recuperaToken(request);
        boolean valid = tokenService.isValid(token);
        if (valid) {
            Integer userId = authClient(token);
            request.setAttribute("id", userId);
        }
        filterChain.doFilter(request, response);
    }
}
