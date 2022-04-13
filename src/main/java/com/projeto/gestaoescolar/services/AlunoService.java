package com.projeto.gestaoescolar.services;

import com.projeto.gestaoescolar.domain.Aluno;
import com.projeto.gestaoescolar.domain.Escola;
import com.projeto.gestaoescolar.domain.Responsavel;
import com.projeto.gestaoescolar.domain.Unidade;
import com.projeto.gestaoescolar.repositories.*;
import com.projeto.gestaoescolar.services.exceptions.AuthorizationException;
import com.projeto.gestaoescolar.services.exceptions.DataIntegrityException;
import com.projeto.gestaoescolar.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private UnidadeService unidadeService;

    @Autowired
    private ResponsavelRepository responsavelRepository;

    @Autowired
    private EscolaRepository escolaRepository;

    @Autowired
    private CoordenadorService coordenadorService;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Aluno create(Aluno aluno) {
        if (coordenadorService.getCoordenador() == null) {
            throw new AuthorizationException("Acesso negado, verifique suas permissões");
        }
        aluno.setId(null);
        Unidade unidade = unidadeService.findUnidadeByCodigoUnidade(aluno.getCodigoUnidade());
        aluno.setUnidade(unidade);
        unidade.setAlunos(Arrays.asList(aluno));

        Responsavel responsavel = aluno.getResponsavel();
        responsavel.setAlunos(Arrays.asList(aluno));
        aluno.setResponsavel(responsavel);

        aluno.getResponsavel().setTelefones(aluno.getResponsavel().getTelefones());
        responsavelRepository.save(responsavel);

        Escola escola = aluno.getEscola();
        escola.setAlunos((Arrays.asList(aluno)));
        aluno.setEscola(escola);

        escola.setEndereco(aluno.getEscola().getEndereco());
        aluno.getEscola().setEndereco(aluno.getEscola().getEndereco());
        enderecoRepository.save(aluno.getEscola().getEndereco());
        escolaRepository.save(escola);
        if (coordenadorService.getCoordenador().getUnidade() != aluno.getUnidade()) {
            throw new AuthorizationException("Acesso negado, verifique sua unidade");
        }
        alunoRepository.save(aluno);
        return aluno;
    }


    public Aluno findAlunoById(Integer id) {
        Aluno aluno = alunoRepository.findAlunoById(id);
        if (aluno == null) {
            throw new ObjectNotFoundException("Aluno não encontrado");
        }
            return aluno;
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

        if(aluno.getNis() == null) {
            aluno.setNis(newAluno.getNis());
        } else {
            newAluno.setNis(aluno.getNis());
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
        findAlunoById(id);
        try {
            alunoRepository.deleteById(id);
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DataIntegrityException("Não é possível excluir um aluno ativo");
        }
    }
}
