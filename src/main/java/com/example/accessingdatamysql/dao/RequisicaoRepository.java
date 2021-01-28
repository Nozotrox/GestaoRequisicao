package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.Requisicao;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RequisicaoRepository extends CrudRepository<Requisicao, Integer> {
    List<Requisicao> findByDocente(Docente docente);
    List<Requisicao> findByDataHoraGreaterThan(Date date);
    List<Requisicao> findByDocenteAndDataHoraGreaterThan(Docente docente, Date date);
}
