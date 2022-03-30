package com.projeto.gestaoescolar.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="COORDENADOR")
public class Coordenador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String username;
    private String senha;
    private String email;

    public Coordenador() {
    }

    public Coordenador(Integer id, String nome, String username, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordenador that = (Coordenador) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
