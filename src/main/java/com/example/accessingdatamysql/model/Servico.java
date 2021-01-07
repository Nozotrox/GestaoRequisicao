package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Servico extends Consumivel{

    @Column(nullable = false, columnDefinition = "boolean default true")
    private boolean disponivel;

    public Servico(){}

    public Servico(String nome, String descricao, @JsonProperty("disponivel") boolean disponivel) {
        super(nome, descricao);
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
