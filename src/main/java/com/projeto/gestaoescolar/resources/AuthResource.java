package com.projeto.gestaoescolar.resources;

import com.projeto.gestaoescolar.domain.ConfirmationToken;
import com.projeto.gestaoescolar.domain.DadosLogin;
import com.projeto.gestaoescolar.services.AutenticacaoService;
import com.projeto.gestaoescolar.domain.AutenticacaoDto;
import com.projeto.gestaoescolar.domain.Coordenador;
import com.projeto.gestaoescolar.repositories.ConfirmationTokenRepository;
import com.projeto.gestaoescolar.repositories.CoordenadorRepository;
import com.projeto.gestaoescolar.services.exceptions.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @Autowired
    private CoordenadorRepository coordenadorRepository;

    @Autowired
    private ConfirmationTokenRepository confirmationTokenRepository;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<AutenticacaoDto> autenticar(@RequestBody DadosLogin dadosLogin) {

 //       Coordenador coordenador = coordenadorRepository.findCoordenadorByUsername(dadosLogin.getUsername());

//        if (coordenador.getAccountActivated()){
            return ResponseEntity.accepted().body(autenticacaoService.doLogin(dadosLogin));
//        }else{
//            throw new AuthorizationException("Confirme seu email para fazer login!");
//        }

    }

    @RequestMapping(value = "/{confirmationToken}", method=RequestMethod.GET)
    public ResponseEntity<Void> confirmToken(@PathVariable String confirmationToken) {
        ConfirmationToken token = confirmationTokenRepository.findByConfirmationToken(confirmationToken);
        if (token != null){
            token.getCoordenador().setAccountActivated(true);
            if (token.getExpiresAt() == null){
                token.setExpiresAt(LocalDateTime.now().plusSeconds(20));
            }
            LocalDateTime expiredAt = token.getExpiresAt();
            if (expiredAt.isBefore(LocalDateTime.now())) {
                throw new AuthorizationException("Token expirado! Solicite um novo token para confirmação de conta.");
            }
            coordenadorRepository.save(token.getCoordenador());

        } else {
            throw new IllegalStateException("Link inválido! Solicite um novo link pelo app");
        }
        return ResponseEntity.noContent().build();
    }
}

