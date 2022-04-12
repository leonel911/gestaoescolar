package com.projeto.gestaoescolar.resources;


import com.projeto.gestaoescolar.domain.Documentacao;
import com.projeto.gestaoescolar.services.DocumentacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/documentacao")
public class DocumentacaoResource {

    @Autowired
    private DocumentacaoService documentacaoService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Documentacao create(@Valid @RequestBody Documentacao documentacao) {
        return documentacaoService.create(documentacao);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Documentacao findById(@PathVariable Integer id) {
        return documentacaoService.findDocumentacaoById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Documentacao> findAll() {
        return documentacaoService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Documentacao update(@PathVariable Integer id, @Valid @RequestBody Documentacao documentacao) {
        documentacao.setId(id);
        return documentacaoService.update(documentacao);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        documentacaoService.delete(id);
    }

}
