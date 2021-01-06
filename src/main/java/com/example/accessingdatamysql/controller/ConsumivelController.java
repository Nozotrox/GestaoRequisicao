package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Material;
import com.example.accessingdatamysql.model.Servico;
import com.example.accessingdatamysql.service.ConsumivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/consumivel/")
public class ConsumivelController {

    @Autowired
    public ConsumivelService consumivelService;

    @PostMapping("/addMat")
    public void addMaterial(@RequestBody Material material) {
        consumivelService.adicionarMaterial(material);
    }

    @PostMapping("/addServ")
    public void addServico(@RequestBody Servico servico) {
        consumivelService.adicionarServico(servico);
    }

}
