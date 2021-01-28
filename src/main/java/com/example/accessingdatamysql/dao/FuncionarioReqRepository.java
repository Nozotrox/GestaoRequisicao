package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.FuncionarioRequisicao;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FuncionarioReqRepository  extends CrudRepository<FuncionarioRequisicao, Integer> {
    List<FuncionarioRequisicao> findByEmailAndPassword(String email, String password);
//    List<FuncionarioRequisicao> findByEmailOrContacto(String contacto);
}
