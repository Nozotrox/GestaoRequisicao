package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.ConsumivelRepository;
import com.example.accessingdatamysql.model.Consumivel;
import com.example.accessingdatamysql.model.Material;
import com.example.accessingdatamysql.model.Servico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ArrayList<Consumivel> getAllConsumiveis() {
        ArrayList<Consumivel> consumiveis = new ArrayList<>();
        consumivelRepository.findAll().forEach(consumiveis::add);
        return consumiveis;
    }

    public Optional<Consumivel> getConsumivelById(int codigo_consumivel) {
        return consumivelRepository.findById(codigo_consumivel);
    }

    public void editarMaterial(Material material) {
        consumivelRepository.save(material);
    }

    public void editarServ(Servico servico) {
        consumivelRepository.save(servico);
    }

    public void removeMat(int codigo_material) {
        consumivelRepository.deleteById(codigo_material);
    }

    public void removeSer(int codigo_servico) {
        consumivelRepository.deleteById(codigo_servico);
    }
}
