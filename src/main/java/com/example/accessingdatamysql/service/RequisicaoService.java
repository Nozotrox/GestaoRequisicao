package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.RequisicaoRepository;
import com.example.accessingdatamysql.model.Requisicao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RequisicaoService {

    @Autowired
    public RequisicaoRepository requisicaoRepository;

    public void adicionarRequisicao(Requisicao requisicao) {
        requisicaoRepository.save(requisicao);
    }

    public void updateRequisicao(Requisicao requisicao) {
        requisicaoRepository.save(requisicao);
    }

    public Optional<Requisicao> getReqById(int codigo_requisicao) {
        return requisicaoRepository.findById(codigo_requisicao);
    }


}
