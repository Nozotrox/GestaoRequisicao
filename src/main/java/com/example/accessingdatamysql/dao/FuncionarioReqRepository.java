package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.FuncionarioRequisicao;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioReqRepository  extends CrudRepository<FuncionarioRequisicao, Integer> {
}
