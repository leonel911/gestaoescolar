package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Aluno;
import com.projeto.gestaoescolar.domain.Escola;
import com.projeto.gestaoescolar.domain.Responsavel;
import com.projeto.gestaoescolar.domain.Unidade;
import com.projeto.gestaoescolar.repositories.AlunoRepository;
import com.projeto.gestaoescolar.repositories.EscolaRepository;
import com.projeto.gestaoescolar.repositories.ResponsavelRepository;
import com.projeto.gestaoescolar.repositories.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private UnidadeRepository unidadeRepository;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    public Aluno create(Aluno aluno) {
        aluno.setId(null);
        Unidade unidade = unidadeRepository.findUnidadeByCodigoUnidade(aluno.getCodigoUnidade());
        aluno.setUnidade(unidade);
        unidade.setAlunos(Arrays.asList(aluno));

        Responsavel responsavel = aluno.getResponsavel();
        responsavel.setAlunos(Arrays.asList(aluno));
        aluno.setResponsavel(responsavel);
        responsavelRepository.save(responsavel);

        Escola escola = aluno.getEscola();
        escola.setAlunos((Arrays.asList(aluno)));
        aluno.setEscola(escola);
        escolaRepository.save(escola);
        alunoRepository.save(aluno);
        unidadeRepository.save(unidade);
        return aluno;
    }


    public Aluno findAlunoById(Integer id) {
        return alunoRepository.findAlunoById(id);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Aluno update(Aluno aluno) {
        Aluno newAluno = findAlunoById(aluno.getId());

        if(aluno.getNome() == null) {
            aluno.setNome(newAluno.getNome());
        } else {
            newAluno.setNome(aluno.getNome());
        }

        if(aluno.getIdadeInicial() == null) {
            aluno.setIdadeInicial(newAluno.getIdadeInicial());
        } else {
            newAluno.setIdadeInicial(aluno.getIdadeInicial());
        }

        if(aluno.getIdadeAtual() == null) {
            aluno.setIdadeAtual(newAluno.getIdadeAtual());
        } else {
            newAluno.setIdadeAtual(aluno.getIdadeAtual());
        }

        if(aluno.getSexo() == null) {
            aluno.setSexo(newAluno.getSexo());
        } else {
            newAluno.setSexo(aluno.getSexo());
        }

        if(aluno.getDataNascimento() == null) {
            aluno.setDataNascimento(newAluno.getDataNascimento());
        } else {
            newAluno.setDataNascimento(aluno.getDataNascimento());
        }

        if(aluno.getDataMatricula() == null) {
            aluno.setDataMatricula(newAluno.getDataMatricula());
        } else {
            newAluno.setDataMatricula(aluno.getDataMatricula());
        }

        if(aluno.getNIS() == null) {
            aluno.setNIS(newAluno.getNIS());
        } else {
            newAluno.setNIS(aluno.getNIS());
        }

        if(aluno.getAcompanhamento() == null) {
            aluno.setAcompanhamento(newAluno.getAcompanhamento());
        } else {
            newAluno.setAcompanhamento(aluno.getAcompanhamento());
        }

        if(aluno.getAutorizadoBuscar() == null) {
            aluno.setAutorizadoBuscar(newAluno.getAutorizadoBuscar());
        } else {
            newAluno.setAutorizadoBuscar(aluno.getAutorizadoBuscar());
        }

        if(aluno.getDesligado() == null) {
            aluno.setDesligado(newAluno.getDesligado());
        } else {
            newAluno.setDesligado(aluno.getDesligado());
        }

        if(aluno.getPeriodoEstudantil() == null) {
            aluno.setPeriodoEstudantil(newAluno.getPeriodoEstudantil());
        } else {
            newAluno.setPeriodoEstudantil(aluno.getPeriodoEstudantil());
        }

        if(aluno.getAnoEscolar() == null) {
            aluno.setAnoEscolar(newAluno.getAnoEscolar());
        } else {
            newAluno.setAnoEscolar(aluno.getAnoEscolar());
        }

        return aluno;

    }

    public void delete(Integer id) {
        alunoRepository.deleteById(id);
    }
}
