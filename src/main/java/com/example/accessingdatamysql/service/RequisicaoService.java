package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.ConsumivelRepository;
import com.example.accessingdatamysql.dao.ConsumivelRequisicaoRepository;
import com.example.accessingdatamysql.dao.RequisicaoRepository;
import com.example.accessingdatamysql.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RequisicaoService {

    @Autowired
    public RequisicaoRepository requisicaoRepository;

    @Autowired
    public ConsumivelRepository consumivelRepository;

    @Autowired
    public ConsumivelRequisicaoRepository csrepository;

    public void adicionarRequisicao(Requisicao requisicao) {
        Requisicao whatever = requisicaoRepository.save(requisicao);

        requisicao.getConsumiveis().forEach(cons -> {
            ConsumivelRequisicao cr = new ConsumivelRequisicao();
            int codigoCons = cons.getCodigo().getConsumivelId();
            int qtdPedida = requisicao.getQtdMap().get(codigoCons);
            cr.setCodigo(new ConsumivelRequisicaoId(codigoCons, whatever.getCodigo()));
            cr.setQuantidade(qtdPedida);

            Optional<Consumivel> materialOptional = consumivelRepository.findById(codigoCons);
            if (materialOptional.isPresent()) {
                Consumivel consumivel = materialOptional.get();
                if(consumivel.getDtype().equals("Material")) {
                    Material mat = (Material) consumivel;
                    mat.setQuantidade(mat.getQuantidade() - qtdPedida);
                    consumivelRepository.save(mat);
                }
            }

            csrepository.save(cr);
        });
    }

    public void updateRequisicao(Requisicao requisicao) {
        EstadoRequisicao estadoRequisicao = requisicao.getEstado();
        if ((estadoRequisicao != EstadoRequisicao.NOVA) && (estadoRequisicao != EstadoRequisicao.CONFIRMADA)) {
            requisicao.getConsumiveis().forEach(cons -> {
                recuperarQuantidadeConsumivel(cons);
            });
        }
        requisicaoRepository.save(requisicao);
    }

    private void recuperarQuantidadeConsumivel(ConsumivelRequisicao cons) {
        Optional<Consumivel> realCons = consumivelRepository.findById(cons.getCodigo().getConsumivelId());
        if(!realCons.isPresent()) return;
        try {
            Material material = (Material) realCons.get();
            if(cons.getConsumivel().getDtype().equals("Material")) {
                material.setQuantidade(cons.getQuantidade() + material.getQuantidade());
                consumivelRepository.save(material);
            }
        } catch (Exception ex) {
            return;
        }

    }

    public void createRequisition (Requisicao requisicao) {

        requisicaoRepository.save(requisicao);
    }

    public Optional<Requisicao> getReqById(int codigo_requisicao) {
        return requisicaoRepository.findById(codigo_requisicao);
    }

    public List<Requisicao> getRequisicoesByCodigoDocente(Docente docente) {
        return requisicaoRepository.findByDocenteAndDataHoraGreaterThan(docente, new Date());
    }

    public List<Requisicao> getAll() {
        ArrayList<Requisicao> requisicoes = new ArrayList<>();
        requisicaoRepository.findAll().forEach(requisicoes::add);
        return requisicoes;
    }

    public List<Requisicao> getTodayRequest(Date date) {
        ArrayList<Requisicao> requisicoes = new ArrayList<>();
        requisicaoRepository.findByDataHoraGreaterThan(date).forEach(requisicoes::add);
        return requisicoes;
    }

}
