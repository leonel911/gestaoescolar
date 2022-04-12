package com.projeto.gestaoescolar.domain;

import java.io.Serializable;

public class DadosLogin implements Serializable {
    private String username;
    private String senha;

    public DadosLogin() {
    }

    public DadosLogin(String username, String senha) {
        this.username = username;
        this.senha = senha;
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
}
