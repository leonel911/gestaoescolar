package com.projeto.gestaoescolar.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projeto.gestaoescolar.domain.enums.Perfil;
import org.hibernate.validator.constraints.Length;
import sun.misc.Perf;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="COORDENADOR")
public class Coordenador implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Nome é obrigatório")
    private String nome;
    @NotEmpty(message = "Username é obrigatório")
    private String username;
    @NotEmpty(message = "Senha é obrigatório")
    @Length(min = 8, message = "Deve ter no mínimo 8 caracteres")
    private String senha;
    @NotEmpty(message = "Email é obrigatório")
    @Email(message = "Email inválido")
    private String email;
    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "coordenador")
    private Unidade unidade;
    private Integer codigoUnidade;
    private Boolean accountActivated;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "coordenador")
    private ConfirmationToken confirmationToken;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
    private Usuario usuario;

    private Perfil perfil;



    public Coordenador() {
        setPerfil(Perfil.COORDENADOR);
    }

    public Coordenador(Integer id, String nome, String username, String senha, String email, Integer codigoUnidade, Perfil perfil) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.senha = senha;
        this.email = email;
        this.codigoUnidade = codigoUnidade;
        this.perfil = perfil;
        setPerfil(Perfil.COORDENADOR);
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

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public Integer getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(Integer codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public ConfirmationToken getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(ConfirmationToken confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Boolean getAccountActivated() {
        return accountActivated;
    }

    public void setAccountActivated(Boolean accountActivated) {
        this.accountActivated = accountActivated;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
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
