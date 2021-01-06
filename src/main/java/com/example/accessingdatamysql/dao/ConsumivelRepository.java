package com.example.accessingdatamysql.dao;

import com.example.accessingdatamysql.model.Consumivel;
import org.springframework.data.repository.CrudRepository;

public interface ConsumivelRepository extends CrudRepository<Consumivel, Integer> {
}
