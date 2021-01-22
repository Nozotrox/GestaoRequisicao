package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class FuncionarioRequisicao extends Usuario {

    @Column(nullable = false, columnDefinition = "varchar(50) default ''")
    private String localizacao;

    @OneToMany(mappedBy = "funcionario")
    private List<Requisicao> requisicoes;

    public FuncionarioRequisicao(){}

    public FuncionarioRequisicao(@JsonProperty("nome") String nome,
                                 @JsonProperty("email") String email,
                                 @JsonProperty("password") String password,
                                 @JsonProperty("contacto") String contacto,
                                 @JsonProperty("genero") Genero genero,
                                 @JsonProperty("localizacao") String localizacao) {
        super(nome, email, password, contacto, genero);
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }
}
