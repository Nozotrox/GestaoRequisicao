package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @Column(nullable = false, columnDefinition = "varchar(255) default ''")
    private String destino;

    @Temporal(TemporalType.DATE)
    private Date dataHora;

    @Enumerated(EnumType.STRING)
    private EstadoRequisicao estado;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "codigo_requisicao"), inverseJoinColumns = @JoinColumn(name = "codigo_consumivel"))
    private List<Consumivel> consumiveis;

    @ManyToOne
    @JoinColumn(name="codigo_docente", nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name="codigo_funcionario", nullable = false)
    private FuncionarioRequisicao funcionario;



    public Requisicao(){}

    public Requisicao(@JsonProperty("destino") String destino,
                      @JsonProperty("dataHora") Date dataHora,
                      @JsonProperty("estado") EstadoRequisicao estado,
                      @JsonProperty("docente") Docente docente) {
        this.destino = destino;
        this.dataHora = dataHora;
        this.estado = estado;
        this.docente = docente;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public EstadoRequisicao getEstado() {
        return estado;
    }

    public void setEstado(EstadoRequisicao estado) {
        this.estado = estado;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public FuncionarioRequisicao getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(FuncionarioRequisicao funcionario) {
        this.funcionario = funcionario;
    }

    public List<Consumivel> getConsumiveis() {
        return consumiveis;
    }

    public void setConsumiveis(List<Consumivel> consumiveis) {
        this.consumiveis = consumiveis;
    }
}
