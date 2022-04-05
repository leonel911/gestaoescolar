package com.projeto.gestaoescolar.resources;

import com.projeto.gestaoescolar.domain.Unidade;
import com.projeto.gestaoescolar.services.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "unidades")
public class UnidadeResource {

    @Autowired
    private UnidadeService unidadeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Unidade create(@Valid @RequestBody Unidade unidade) {
        return unidadeService.create(unidade);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Unidade findById(@PathVariable Integer id) {
        return unidadeService.findById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Unidade> findAll() {
        return unidadeService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Unidade update(@PathVariable Integer id, @Valid @RequestBody Unidade unidade) {
        unidade.setId(id);
        return unidadeService.update(unidade);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        unidadeService.delete(id);
    }




}
