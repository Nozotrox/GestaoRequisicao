package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.ConsumivelRepository;
import com.example.accessingdatamysql.model.Material;
import com.example.accessingdatamysql.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumivelService {

    @Autowired
    public ConsumivelRepository consumivelRepository;

    public void adicionarMaterial(Material material) {
        consumivelRepository.save(material);
    }

    public void adicionarServico(Servico servico) {
        consumivelRepository.save(servico);
    }
}
