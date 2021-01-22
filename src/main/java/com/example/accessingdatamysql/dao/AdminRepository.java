package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Administrador;
import com.example.accessingdatamysql.model.Docente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AdminRepository extends CrudRepository<Administrador, Integer> {

    List<Administrador> findByEmailAndPassword(String email, String password);
}
