package com.projeto.gestaoescolar.resources;

import com.projeto.gestaoescolar.domain.AutenticacaoDto;
import com.projeto.gestaoescolar.domain.Coordenador;
import com.projeto.gestaoescolar.domain.DadosLogin;
import com.projeto.gestaoescolar.services.AutenticacaoService;
import com.projeto.gestaoescolar.services.CoordenadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/coordenadores")
public class CoordenadorResource {

    @Autowired
    private CoordenadorService coordenadorService;

    @Autowired
    private AutenticacaoService autenticacaoService;

    @RequestMapping(value = "/create",method=RequestMethod.POST)
    public ResponseEntity<AutenticacaoDto> insert(@Valid @RequestBody Coordenador coordenador) {
        coordenadorService.create(coordenadorService.toCoordenadorModel(coordenador));
        AutenticacaoDto response = autenticacaoService.doLogin(new DadosLogin(coordenador.getUsername(), coordenador.getSenha()));
        return ResponseEntity.ok(response);
    }


    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Coordenador findById(@PathVariable Integer id) {
        return coordenadorService.findById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Coordenador> findAll(){
        return coordenadorService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Coordenador update(@PathVariable Integer id, @Valid @RequestBody Coordenador coordenador) {
        coordenador.setId(id);
        return coordenadorService.update(coordenador);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        coordenadorService.delete(id);
    }


}
