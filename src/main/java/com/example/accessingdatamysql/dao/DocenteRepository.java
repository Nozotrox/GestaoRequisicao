package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface DocenteRepository extends CrudRepository<Docente, Integer> {
}
