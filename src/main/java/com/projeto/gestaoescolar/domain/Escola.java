package com.projeto.gestaoescolar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ESCOLA")
public class Escola implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;


    @OneToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @JsonIgnore
    @OneToMany(mappedBy = "escola")
    private List<Aluno> alunos;

    public Escola() {
    }

    public Escola(Integer id, String nome, Endereco endereco, List<Aluno> alunos) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.alunos = alunos;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Escola escola = (Escola) o;
        return id.equals(escola.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
