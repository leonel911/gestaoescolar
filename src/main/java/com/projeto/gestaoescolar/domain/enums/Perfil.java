package com.projeto.gestaoescolar.domain.enums;

public enum Perfil {

    ADMIN("Administrador"),
    COORDENADOR("Coordenador");

    private String descricao;

    Perfil(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
