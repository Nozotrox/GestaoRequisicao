package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.*;
import com.example.accessingdatamysql.model.*;
import com.example.accessingdatamysql.responseRequestBodies.UserCount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    public DocenteRepository docenteRepository;

    @Autowired
    public AdminRepository adminRepository;

    @Autowired
    public FuncionarioReqRepository funcionarioReqRepository;

    @Autowired
    public ConsumivelRepository consumivelRepository;

    @Autowired
    public RequisicaoRepository requisicaoRepository;



    public boolean isAdmin(String email, String password) {
        List<Administrador> admin = adminRepository.findByEmailAndPassword(email, password);
        if (admin.isEmpty()) return false;
        return true;
    }

    public UserCount getUserCount() {
        List<Docente> docentes = (List<Docente>) docenteRepository.findAll();
        List<FuncionarioRequisicao> funcionarios = (List<FuncionarioRequisicao>) funcionarioReqRepository.findAll();
        List<Administrador> admins = (List<Administrador>) adminRepository.findAll();
        List<Requisicao> reqs = (List<Requisicao>) requisicaoRepository.findAll();

        int total_docentes = docentes.size();
        int total_funcionarios = funcionarios.size();
        int total_usuarios = total_docentes + total_funcionarios + admins.size();
        int total_requisicoes = reqs.size();

        UserCount ucount = new UserCount();
        ucount.total_docentes = total_docentes;
        ucount.total_funcionarios = total_funcionarios;
        ucount.total_usuarios = total_usuarios;
        ucount.total_requisicoes = total_requisicoes;

        return ucount;
    }

    public ArrayList<HashMap<String, Integer>> getConsCount() {
        HashMap<String, Integer> counterMaterials = new HashMap<>();
        HashMap<String, Integer> counterServices = new HashMap<>();
        ArrayList<Material> materials = new ArrayList<>();
        ArrayList<Servico> servicos = new ArrayList<>();
        ArrayList<Consumivel> consumiveis  = new ArrayList<>();
        ArrayList<HashMap<String, Integer>> toReturn = new ArrayList<>();


        consumivelRepository.findAll().forEach(consumiveis::add);
        consumiveis.stream().filter(consumivel -> consumivel instanceof Material).forEach(material -> {materials.add((Material) material);});
        consumiveis.stream().filter(consumivel -> consumivel instanceof Servico).forEach(servico -> {servicos.add((Servico) servico);});

        materials.forEach(material -> {
            String name = material.getNome();
            int qtd = material.getQuantidade();
            counterMaterials.put(name, qtd);
        });

        servicos.forEach(servico -> {
            String name = servico.getNome();
            int qtd = servico.isDisponivel()? 1:0;
            counterServices.put(name, qtd);
        });

        toReturn.add(counterMaterials);
        toReturn.add(counterServices);

        return toReturn;
    }

    public ArrayList<Requisicao> getAllReq() {
        ArrayList<Requisicao> requisicoes = new ArrayList<>();
        requisicaoRepository.findAll().forEach(requisicoes::add);

//        requisicoes.forEach(requisicao -> {
//            Optional<Consumivel> cons;
//            for (Consumivel consumivei : requisicao.getConsumiveis()) {
//                cons =  consumivelRepository.findById(consumivei.getCodigo());
//                if (cons.isPresent()) {
//                    if (cons.get().getDtype().equals("Material")) requisicao.incrementTotalMaterial(); else requisicao.incrementTotalServices();
//                }
//            }
//        });

        return requisicoes;
    }


}
