package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.ConsumivelRepository;
import com.example.accessingdatamysql.model.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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

    public void test() {
        FileReader file = null;
        try {
            file = new FileReader("C:\\Users\\nozotrox\\Downloads\\gs-accessing-data-mysql-master\\complete\\src\\main\\java\\com\\example\\accessingdatamysql\\service\\materiais.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONParser parser = new JSONParser();


        try {
            Object object = parser.parse(file);
            JSONArray jsonArray = (JSONArray) object;
//            DOCENTE PROPERTIES
            String nome, descricao;
            int quantidade;
            Long intMed;
            int disponivel = 1;
            for (Object obj : jsonArray) {
                JSONObject jsonObj = ((JSONObject)obj);
                nome = (String) jsonObj.get("nome");
                descricao = (String) jsonObj.get("descricao");
                intMed = (Long) jsonObj.get("quantidade");
                quantidade = Integer.parseInt(intMed.toString());

                Material mat = new Material(nome, descricao, quantidade);
                consumivelRepository.save(mat);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
