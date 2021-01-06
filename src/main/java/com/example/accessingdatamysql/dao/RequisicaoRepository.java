package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Requisicao;
import org.springframework.data.repository.CrudRepository;

public interface RequisicaoRepository extends CrudRepository<Requisicao, Integer> {
}
