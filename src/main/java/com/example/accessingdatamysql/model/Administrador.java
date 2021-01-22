package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Administrador extends Usuario {

    @Column(nullable = true, columnDefinition = "varchar(50) default ''")
    private String departamento = "";

    public Administrador(){}

    public Administrador(@JsonProperty("nome") String nome,
                         @JsonProperty("email") String email,
                         @JsonProperty("password") String password,
                         @JsonProperty("contacto") String contacto,
                         @JsonProperty("genero") Genero genero,
                         @JsonProperty("departamento") String departamento) {
        super(nome, email, password, contacto, genero);
        this.departamento = departamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
