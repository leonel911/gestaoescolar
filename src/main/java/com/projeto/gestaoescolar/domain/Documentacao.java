package com.projeto.gestaoescolar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "DOCUMENTACAO")
public class Documentacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "CPF é obrigatório")
    private String numeroCpf;
    @NotEmpty(message = "RG é obrigatório")
    private String numeroRg;
    @NotEmpty(message = "CTPS é obrigatório")
    private String ctps;
    private Date dataEmissaoRg;
    @NotEmpty(message = "Orgão Expeditor é obrigatório")
    private String orgaoExpeditorRg;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "documentacao")
    private Responsavel responsavel;

    public Documentacao() {
    }

    public Documentacao(Integer id, String numeroCpf, String numeroRg, String ctps, Date dataEmissaoRg, String orgaoExpeditorRg) {
        this.id = id;
        this.numeroCpf = numeroCpf;
        this.numeroRg = numeroRg;
        this.ctps = ctps;
        this.dataEmissaoRg = dataEmissaoRg;
        this.orgaoExpeditorRg = orgaoExpeditorRg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroCpf() {
        return numeroCpf;
    }

    public void setNumeroCpf(String numeroCpf) {
        this.numeroCpf = numeroCpf;
    }

    public String getNumeroRg() {
        return numeroRg;
    }

    public void setNumeroRg(String numeroRg) {
        this.numeroRg = numeroRg;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public Date getDataEmissaoRg() {
        return dataEmissaoRg;
    }

    public void setDataEmissaoRg(Date dataEmissaoRg) {
        this.dataEmissaoRg = dataEmissaoRg;
    }

    public String getOrgaoExpeditorRg() {
        return orgaoExpeditorRg;
    }

    public void setOrgaoExpeditorRg(String orgaoExpeditorRg) {
        this.orgaoExpeditorRg = orgaoExpeditorRg;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Documentacao that = (Documentacao) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
