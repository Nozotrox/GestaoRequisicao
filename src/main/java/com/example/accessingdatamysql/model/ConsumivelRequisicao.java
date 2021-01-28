package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ConsumivelRequisicao {

    @EmbeddedId
    private ConsumivelRequisicaoId codigo;

    @ManyToOne
    @JoinColumn(name = "fk_consumivel", insertable = false, updatable = false)
    private Consumivel consumivel;

    @ManyToOne
    @JoinColumn(name = "fk_requisicao", insertable = false, updatable = false)
    @JsonIgnore
    private Requisicao requisicao;

    @Column
    private int quantidade;

    public ConsumivelRequisicao() { }


    public ConsumivelRequisicao(Consumivel consumivel, Requisicao requisicao, int quantidade) {

        this.codigo = new ConsumivelRequisicaoId(consumivel.getCodigo(), requisicao.getCodigo());
        this.consumivel = consumivel;
        this.requisicao = requisicao;
        this.quantidade = quantidade;


        consumivel.getRequisicoes().add(this);
        requisicao.getConsumiveis().add(this);
    }

    public ConsumivelRequisicaoId getCodigo() {
        return codigo;
    }

    public void setCodigo(ConsumivelRequisicaoId codigo) {
        this.codigo = codigo;
    }

    public Consumivel getConsumivel() {
        return consumivel;
    }

    public void setConsumivel(Consumivel consumivel) {
        this.consumivel = consumivel;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}


