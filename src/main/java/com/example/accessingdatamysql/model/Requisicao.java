package com.example.accessingdatamysql.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.*;

@Entity
public class Requisicao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codigo;

    @Column(nullable = false, columnDefinition = "varchar(255) default ''")
    private String destino;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date dataHora;

    @Enumerated(EnumType.STRING)
    private EstadoRequisicao estado;

//    @ManyToMany
//    @JoinTable(joinColumns = @JoinColumn(name = "codigo_requisicao"), inverseJoinColumns = @JoinColumn(name = "codigo_consumivel"))
//    private List<Consumivel> consumiveis;


    @OneToMany(mappedBy = "requisicao")
    private Set<ConsumivelRequisicao> consumiveis = new HashSet<ConsumivelRequisicao>();

    @ManyToOne
    @JoinColumn(name="codigo_docente", nullable = false)
    private Docente docente;

    @ManyToOne
    @JoinColumn(name="codigo_funcionario", nullable = true)
    private FuncionarioRequisicao funcionario;


    @Transient
    int totalMaterial;

    @Transient
    int totalServico;

    @Transient
    HashMap<Integer, Integer> qtdMap;

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

//    public List<Consumivel> getConsumiveis() {
//        return consumiveis;
//    }
//
//    public void setConsumiveis(List<Consumivel> consumiveis) {
//        this.consumiveis = consumiveis;
//    }


    public Set<ConsumivelRequisicao> getConsumiveis() {
        return consumiveis;
    }

    public void setConsumiveis(Set<ConsumivelRequisicao> consumiveis) {
        this.consumiveis = consumiveis;
    }

    public int getTotalMaterial() {
        return totalMaterial;
    }

    public void setTotalMaterial(int totalMaterial) {
        this.totalMaterial = totalMaterial;
    }

    public void incrementTotalMaterial() {
        this.totalMaterial++;
    }

    public void incrementTotalServices() {
        this.totalServico++;
    }

    public int getTotalServico() {
        return totalServico;
    }

    public HashMap<Integer, Integer> getQtdMap() {
        return qtdMap;
    }

    public void setQtdMap(HashMap<Integer, Integer> qtdMap) {
        this.qtdMap = qtdMap;
    }

    public void setTotalServico(int totalServico) {
        this.totalServico = totalServico;
    }


}
