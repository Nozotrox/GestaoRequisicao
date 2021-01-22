package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Consumivel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConsumivelRepository extends CrudRepository<Consumivel, Integer> {

}
