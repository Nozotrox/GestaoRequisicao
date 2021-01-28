package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DocenteRepository extends CrudRepository<Docente, Integer> {

    List<Docente> findByEmailAndPassword(String email, String password);
    List<Docente> findByEmailOrContacto(String contacto);

}
