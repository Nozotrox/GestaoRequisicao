package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Consumivel;
import com.example.accessingdatamysql.model.Material;
import com.example.accessingdatamysql.model.Servico;
import com.example.accessingdatamysql.service.ConsumivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/consumivel/")
public class ConsumivelController {

    @Autowired
    public ConsumivelService consumivelService;

    @PostMapping("/addMat")
    public String addMaterial(@RequestBody Material material) {
        try {
            consumivelService.adicionarMaterial(material);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Sucesso";
    }

    @PostMapping("/addServ")
    public String addServico(@RequestBody Servico servico) {
        try {
            consumivelService.adicionarServico(servico);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Sucesso";
    }

    @GetMapping("/getAll")
    @ResponseBody
    public ArrayList<Consumivel> getAllConsumiveis() {
        return consumivelService.getAllConsumiveis();
    }

    @GetMapping("/getCons/{codigo_consumivel}")
    @ResponseBody
    public Consumivel getConsById(@PathVariable int codigo_consumivel) {
        Optional<Consumivel> consOptional = consumivelService.getConsumivelById(codigo_consumivel);
        if (consOptional.isPresent()) {
            return consOptional.get();
        }
        return null;
    }

    @PutMapping("/updateMat")
    public String updateMat (@RequestBody Material material) {
        try {
            consumivelService.editarMaterial(material);
        } catch ( Exception ex ) {
            return ex.getMessage();
        }
        return "Success";
    }

    @PutMapping("/updateServ")
    public String updateServ (@RequestBody Servico servico) {
        try {
            consumivelService.editarServ(servico);
        } catch ( Exception ex ) {
            return ex.getMessage();
        }
        return "Success";
    }

    @DeleteMapping("/deleteServ/{codigo_servico}")
    public String removeServico (@PathVariable int codigo_servico) {
        try {
            consumivelService.removeSer(codigo_servico);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Success";
    }

    @DeleteMapping("/deleteMat/{codigo_material}")
    public String removeMat (@PathVariable int codigo_material) {
        try {
            consumivelService.removeMat(codigo_material);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Success";
    }


}
