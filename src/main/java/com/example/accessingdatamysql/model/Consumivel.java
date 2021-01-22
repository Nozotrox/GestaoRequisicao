package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "consumivel")
public class Consumivel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int codigo;

    @Column(nullable = false, columnDefinition = "varchar(255) default ''")
    protected String nome;

    @Column(nullable = false, columnDefinition = "varchar(255) default ''")
    protected String descricao;

    @ManyToMany(mappedBy = "consumiveis")
    protected List<Requisicao> requisicoes;

    @Column(insertable = false, updatable = false) private String dtype;

    public Consumivel(){}

    public Consumivel(@JsonProperty("nome") String nome, @JsonProperty("descricao") String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }
}
