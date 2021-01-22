package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.Requisicao;
import com.example.accessingdatamysql.model.Usuario;
import com.example.accessingdatamysql.service.RequisicaoService;
import com.example.accessingdatamysql.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/requisicao")
public class RequisicaoController {

    @Autowired
    public RequisicaoService requisicaoService;


    @PostMapping("/addReq")
    public String adicionarRequisicao(@RequestBody Requisicao requisicao) {
        try {
            requisicaoService.adicionarRequisicao(requisicao);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Sucesso";
    }

    @PutMapping("/updateReq")
    public String updateRequest(@RequestBody Requisicao requisicao) {
        try {
            requisicaoService.updateRequisicao(requisicao);
        } catch ( Exception ex ) {
            return ex.getMessage();
        }
        return "Sucesso";
    }

    @GetMapping("/getReq/{codigo_requisicao}")
    @ResponseBody
    public Requisicao getAllRequests(@PathVariable int codigo_requisicao) {
        Optional<Requisicao> requisicaoOptional = requisicaoService.getReqById(codigo_requisicao);
        if (requisicaoOptional.isPresent()) {
            return requisicaoOptional.get();
        }
        return null;
    }

}
