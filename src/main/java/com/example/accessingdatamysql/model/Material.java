package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Material extends Consumivel{

    @Column(nullable = false, columnDefinition = "integer default 1")
    private int quantidade;

    public Material(){}

    public Material(@JsonProperty("nome") String nome,@JsonProperty("descricao") String descricao, @JsonProperty("quantidade") int quantidade) {
        super(nome, descricao);
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
