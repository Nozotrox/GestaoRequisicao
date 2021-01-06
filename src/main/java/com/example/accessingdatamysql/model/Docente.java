package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import javax.print.Doc;
import java.util.ArrayList;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Docente extends Usuario {

    @Column(nullable = false, columnDefinition = "varchar(50) default ''")
    private String cadeira;

    @Column(nullable = false)
    private int numero_requisicoes;

    @OneToMany(mappedBy = "docente")
    private Set<Requisicao> requisicoes;



    public Docente(){}

    public Docente (String nome, String email, String password, String contacto, Genero genero, @JsonProperty("cadeira") String cadeira, @JsonProperty("numero_requisicoes") int numero_requisicoes) {
        super(nome, email, password, contacto, genero);
        this.cadeira = cadeira;
        this.numero_requisicoes = numero_requisicoes;
    }


    public String getCadeira() {
        return cadeira;
    }

    public void setCadeira(String cadeira) {
        this.cadeira = cadeira;
    }

    public int getNumero_requisicoes() {
        return numero_requisicoes;
    }

    public void setNumero_requisicoes(int numero_requisicoes) {
        this.numero_requisicoes = numero_requisicoes;
    }
}
