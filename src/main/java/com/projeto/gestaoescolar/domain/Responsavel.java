package com.projeto.gestaoescolar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.relational.core.sql.In;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "RESPONSAVEL")
public class Responsavel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;
    @ElementCollection
    @CollectionTable(name = "TELEFONE")
    private Set<String> telefones = new HashSet<>();
    private Date dataNascimento;
    @NotEmpty(message = "NIS é obrigatório")
    private String nisResponsavel;
    @NotEmpty(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;
    private String observacao;
    @JsonIgnore
    @OneToMany(mappedBy = "responsavel")
    private List<Aluno> alunos;

    @OneToOne
    @JoinColumn(name = "documentacao_id")
    private Documentacao documentacao;

    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    public Responsavel() {
    }

    public Responsavel(Integer id, String nome, Set<String> telefones, Date dataNascimento, String nisResponsavel, String email, String observacao) {
        this.id = id;
        this.nome = nome;
        this.telefones = telefones;
        this.dataNascimento = dataNascimento;
        this.nisResponsavel = nisResponsavel;
        this.email = email;
        this.observacao = observacao;
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

    public Set<String> getTelefones() {
        return telefones;
    }

    public void setTelefones(Set<String> telefones) {
        this.telefones = telefones;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getNisResponsavel() {
        return nisResponsavel;
    }

    public void setNisResponsavel(String nisResponsavel) {
        this.nisResponsavel = nisResponsavel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Documentacao getDocumentacao() {
        return documentacao;
    }

    public void setDocumentacao(Documentacao documentacao) {
        this.documentacao = documentacao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Responsavel that = (Responsavel) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
