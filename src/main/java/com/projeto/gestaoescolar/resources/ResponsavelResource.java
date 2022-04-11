package com.projeto.gestaoescolar.resources;

import com.projeto.gestaoescolar.domain.Responsavel;
import com.projeto.gestaoescolar.services.ResponsavelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/responsaveis")
public class ResponsavelResource {

    @Autowired
    private ResponsavelService responsavelService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Responsavel create(@Valid @RequestBody Responsavel responsavel) {
        return responsavelService.create(responsavel);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Responsavel findResponsavelById(@PathVariable Integer id) {
        return responsavelService.findResponsavelById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Responsavel> findAll() {
        return responsavelService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public Responsavel update(@PathVariable Integer id, @Valid @RequestBody Responsavel responsavel) {
        responsavel.setId(id);
        return responsavelService.update(responsavel);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        responsavelService.delete(id);
    }

}
