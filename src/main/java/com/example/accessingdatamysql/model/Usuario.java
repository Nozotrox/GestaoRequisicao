package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@MappedSuperclass
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected int codigo;

    @Column(nullable = false)
    protected String nome;

    @Column(unique = true)
    protected String email;

    @Column(nullable = false)
    protected String password;

    @Column(nullable = false, unique = true)
    protected String contacto;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected Genero genero;

    @Transient
    @Enumerated(EnumType.STRING)
    public TypeUser typeUser;

    public Usuario () {}

    public Usuario(@JsonProperty("nome") String nome,
                   @JsonProperty("email") String email,
                   @JsonProperty("password") String password,
                   @JsonProperty("contacto") String contacto,
                   @JsonProperty("genero") Genero genero) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.contacto = contacto;
        this.genero = genero;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }


    public TypeUser getTypeUser() {
        return typeUser;
    }

    public void setTypeUser(TypeUser typeUser) {
        this.typeUser = typeUser;
    }
}
