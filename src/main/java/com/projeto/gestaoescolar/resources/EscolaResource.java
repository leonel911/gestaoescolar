package com.projeto.gestaoescolar.resources;

import com.projeto.gestaoescolar.domain.Escola;
import com.projeto.gestaoescolar.services.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/escolas")
public class EscolaResource {

    @Autowired
    private EscolaService escolaService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Escola create(@Valid @RequestBody Escola escola) {
        return escolaService.create(escola);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Escola findById(@PathVariable Integer id) {
        return escolaService.findEscolaById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Escola> findAll() {
        return escolaService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Escola update(@PathVariable Integer id, @Valid @RequestBody Escola escola) {
        escola.setId(id);
        return escolaService.update(escola);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        escolaService.delete(id);
    }

}
