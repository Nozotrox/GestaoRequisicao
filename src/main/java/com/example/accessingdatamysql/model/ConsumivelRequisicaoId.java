package com.example.accessingdatamysql.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ConsumivelRequisicaoId implements Serializable {

    @Column(name = "fk_consumivel")
    protected Integer consumivelId;

    @Column(name = "fk_requisicao")
    protected Integer requisicaoId;

    public ConsumivelRequisicaoId(){

    }

    public ConsumivelRequisicaoId(int consumivelId) {
        this.consumivelId = consumivelId;
    }

    public ConsumivelRequisicaoId(Integer consumivelId, Integer requisicaoId) {
        this.consumivelId = consumivelId;
        this.requisicaoId = requisicaoId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((consumivelId == null) ? 0 : consumivelId.hashCode());
        result = prime * result
                + ((requisicaoId == null) ? 0 : requisicaoId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;

        ConsumivelRequisicaoId other = (ConsumivelRequisicaoId) obj;

        if (consumivelId == null) {
            if (other.consumivelId != null)
                return false;
        } else if (!consumivelId.equals(other.consumivelId))
            return false;

        if (requisicaoId == null) {
            if (other.requisicaoId != null)
                return false;
        } else if (!requisicaoId.equals(other.requisicaoId))
            return false;

        return true;
    }

    public Integer getConsumivelId() {
        return consumivelId;
    }

    public void setConsumivelId(Integer consumivelId) {
        this.consumivelId = consumivelId;
    }

    public Integer getRequisicaoId() {
        return requisicaoId;
    }

    public void setRequisicaoId(Integer requisicaoId) {
        this.requisicaoId = requisicaoId;
    }
}
