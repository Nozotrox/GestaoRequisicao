package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.AdminRepository;
import com.example.accessingdatamysql.dao.DocenteRepository;
import com.example.accessingdatamysql.dao.FuncionarioReqRepository;
import com.example.accessingdatamysql.dao.RequisicaoRepository;
import com.example.accessingdatamysql.model.*;
import com.example.accessingdatamysql.responseRequestBodies.UserCount;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    public DocenteRepository docenteRepository;

    @Autowired
    public FuncionarioReqRepository funcionarioReqRepository;

    @Autowired
    public AdminRepository adminRepository;

    @Autowired
    public RequisicaoRepository requisicaoRepository;


    public void adicionarDocente(Docente docente){
        docenteRepository.save(docente);
    }

    public ArrayList<Docente> getAllDocs() {
        ArrayList<Docente> docentes = new ArrayList<>();
        docenteRepository.findAll().forEach(docentes::add);
        return docentes;
    }

    public Optional<Docente> getDocenteById(int codigo_docente) {
        return docenteRepository.findById(codigo_docente);
    }

    public void removeDocenteById(int codigo_docente) {
        docenteRepository.deleteById(codigo_docente);
    }

    public void updateDocente(Docente docente) {
        docenteRepository.save(docente);
    }

    public Docente findDocenteByEmail(String email, String password) {
        List<Docente> docenteList = docenteRepository.findByEmailAndPassword(email, password);
        if (docenteList.isEmpty()) return null;
        return docenteList.get(0);
    }


    public void adicionarFuncionarioRequisicao(FuncionarioRequisicao funcionarioRequisicao) {
        funcionarioReqRepository.save(funcionarioRequisicao);
    }

    public ArrayList<FuncionarioRequisicao> getAllFuncReq() {
        ArrayList<FuncionarioRequisicao> funcionarios = new ArrayList<>();
        funcionarioReqRepository.findAll().forEach(funcionarios::add);
        return funcionarios;
    }

    public Optional<FuncionarioRequisicao> getFuncReqById(int codigo_func) {
        return funcionarioReqRepository.findById(codigo_func);
    }

    public void updateFuncReq(FuncionarioRequisicao funcionarioRequisicao) {
        funcionarioReqRepository.save(funcionarioRequisicao);
    }

    public FuncionarioRequisicao findFuncReqByEmailPassword(String email, String password) {
        List<FuncionarioRequisicao> funcreq = funcionarioReqRepository.findByEmailAndPassword(email, password);
        if(funcreq.isEmpty()) return null;
        return funcreq.get(0);
    }

    public void removeFuncReqById(int codigo_funcreq) {
        funcionarioReqRepository.deleteById(codigo_funcreq);
    }


    public void adicionarAdmin(Administrador admin) {
        adminRepository.save(admin);
    }

    public ArrayList<Administrador> getAllAdmins() {
        ArrayList<Administrador> admins = new ArrayList<>();
        adminRepository.findAll().forEach(admins::add);
        return admins;
    }

    public Administrador findAdminByEmailPassword(String email, String password) {
        List<Administrador> docenteList = adminRepository.findByEmailAndPassword(email, password);
        if (docenteList.isEmpty()) return null;
        return docenteList.get(0);
    }

    public void updateAdmin(Administrador admin) {
        adminRepository.save(admin);
    }

    public Optional<Administrador> getAdminById(int codigo_admin) {
        return adminRepository.findById(codigo_admin);
    }

    public void removeAdminById (int codigo_admin) {
        adminRepository.deleteById(codigo_admin);
    }



    public void test() {
        FileReader file = null;
        try {
            file = new FileReader("C:\\Users\\nozotrox\\Downloads\\gs-accessing-data-mysql-master\\complete\\src\\main\\java\\com\\example\\accessingdatamysql\\service\\admin.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONParser parser = new JSONParser();


        try {
            Object object = parser.parse(file);
            JSONArray jsonArray = (JSONArray) object;
//            DOCENTE PROPERTIES
            String nome, contacto, password, cadeira, email, localizacao, departamento;
            int numero_requisicoes;
            Genero genero;
            for (Object obj : jsonArray) {
                JSONObject jsonObj = ((JSONObject)obj);
                nome = jsonObj.get("nome") + " " + jsonObj.get("apelido");
                genero = ((String)jsonObj.get("genero")).equals("Male")? Genero.MASCULINO: Genero.FEMININO;
                contacto = "8" + Math.ceil(Math.random() * 4) + 1 + Math.ceil(Math.random() * 10000000);
                password = (String) jsonObj.get("password");
                email = (String) jsonObj.get("email");

                /*DOCENTE*/
//                cadeira = (String) jsonObj.get("cadeira");
//                Long longadsf = (Long) jsonObj.get("numero_requisicoes");
//                numero_requisicoes =  Integer.parseInt(longadsf.toString());

//               /*FUNCIONARIO_REQUISICAO*/
//                localizacao = (String) jsonObj.get("localizacao");

                /*ADMIN*/
                departamento = (String) jsonObj.get("departamento");
                Administrador doc = new Administrador(nome, email, password, contacto, genero, departamento);

                adminRepository.save(doc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
