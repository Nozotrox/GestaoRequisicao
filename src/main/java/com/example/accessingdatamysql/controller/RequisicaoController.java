package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.Requisicao;
import com.example.accessingdatamysql.model.Usuario;
import com.example.accessingdatamysql.service.RequisicaoService;
import com.example.accessingdatamysql.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/requisicao")
public class RequisicaoController {

    @Autowired
    public RequisicaoService requisicaoService;


    @PostMapping("/addReq")
    public String adicionarRequisicao(@RequestBody Requisicao requisicao) {
        requisicaoService.adicionarRequisicao(requisicao);
        return "Sucesso";
    }
}
