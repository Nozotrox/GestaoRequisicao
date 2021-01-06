package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Administrador;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Administrador, Integer> {
}
