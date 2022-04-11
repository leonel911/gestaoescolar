package com.projeto.gestaoescolar.resources;

import com.projeto.gestaoescolar.domain.Aluno;
import com.projeto.gestaoescolar.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {

    @Autowired
    private AlunoService alunoService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Aluno create(@Valid @RequestBody Aluno aluno) {
        return alunoService.create(aluno);
    }

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public Aluno findById(@PathVariable Integer id) {
        return alunoService.findAlunoById(id);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Aluno> findAll() {
        return alunoService.findAll();
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Aluno update(@PathVariable Integer id, @Valid @RequestBody Aluno aluno) {
        aluno.setId(id);
        return alunoService.update(aluno);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        alunoService.delete(id);
    }

}
