package com.projeto.gestaoescolar.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ALUNO")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "O nome é obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 20 caracteres")
    private String nome;
    private Integer idadeInicial;
    private Integer idadeAtual;
    private String sexo;
    private Date dataNascimento;
    private Date dataMatricula;
    @NotEmpty(message = "O NIS é obrigatório")
    private String nis;
    private Boolean acompanhamento;
    private String autorizadoBuscar;
    private Boolean desligado;
    private String periodoEstudantil;
    private Integer anoEscolar;
    private Integer codigoUnidade;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "unidade_id")
    private Unidade unidade;

    @ManyToOne
    @JoinColumn(name = "responsavel_id")
    private Responsavel responsavel;

    @ManyToOne
    @JoinColumn(name = "escola_id")
    private Escola escola;



    public Aluno() {
    }

    public Aluno(Integer id, String nome, Integer idadeInicial, Integer idadeAtual, String sexo, Date dataNascimento, Date dataMatricula, String nis, Boolean acompanhamento, String autorizadoBuscar, Boolean desligado, String periodoEstudantil, Integer anoEscolar, Integer codigoUnidade) {
        this.id = id;
        this.nome = nome;
        this.idadeInicial = idadeInicial;
        this.idadeAtual = idadeAtual;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.dataMatricula = dataMatricula;
        this.nis = nis;
        this.acompanhamento = acompanhamento;
        this.autorizadoBuscar = autorizadoBuscar;
        this.desligado = desligado;
        this.periodoEstudantil = periodoEstudantil;
        this.anoEscolar = anoEscolar;
        this.codigoUnidade = codigoUnidade;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdadeInicial() {
        return idadeInicial;
    }

    public void setIdadeInicial(Integer idadeInicial) {
        this.idadeInicial = idadeInicial;
    }

    public Integer getIdadeAtual() {
        return idadeAtual;
    }

    public void setIdadeAtual(Integer idadeAtual) {
        this.idadeAtual = idadeAtual;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    public Boolean getAcompanhamento() {
        return acompanhamento;
    }

    public void setAcompanhamento(Boolean acompanhamento) {
        this.acompanhamento = acompanhamento;
    }

    public String getAutorizadoBuscar() {
        return autorizadoBuscar;
    }

    public void setAutorizadoBuscar(String autorizadoBuscar) {
        this.autorizadoBuscar = autorizadoBuscar;
    }

    public Boolean getDesligado() {
        return desligado;
    }

    public void setDesligado(Boolean desligado) {
        this.desligado = desligado;
    }

    public String getPeriodoEstudantil() {
        return periodoEstudantil;
    }

    public void setPeriodoEstudantil(String periodoEstudantil) {
        this.periodoEstudantil = periodoEstudantil;
    }

    public Integer getAnoEscolar() {
        return anoEscolar;
    }

    public void setAnoEscolar(Integer anoEscolar) {
        this.anoEscolar = anoEscolar;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    public Integer getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(Integer codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return id.equals(aluno.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
