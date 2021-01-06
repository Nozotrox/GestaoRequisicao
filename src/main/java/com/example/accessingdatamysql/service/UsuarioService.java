package com.example.accessingdatamysql.service;

import com.example.accessingdatamysql.dao.AdminRepository;
import com.example.accessingdatamysql.dao.DocenteRepository;
import com.example.accessingdatamysql.dao.FuncionarioReqRepository;
import com.example.accessingdatamysql.model.Administrador;
import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.FuncionarioRequisicao;
import com.example.accessingdatamysql.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    public DocenteRepository docenteRepository;

    @Autowired
    public FuncionarioReqRepository funcionarioReqRepository;

    @Autowired
    public AdminRepository adminRepository;

    public void adicionarDocente(Docente docente){
        docenteRepository.save(docente);
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

    public void adicionarFuncionarioRequisicao(FuncionarioRequisicao funcionarioRequisicao) {
        funcionarioReqRepository.save(funcionarioRequisicao);
    }

    public Optional<FuncionarioRequisicao> getFuncReqById(int codigo_func) {
        return funcionarioReqRepository.findById(codigo_func);
    }

    public void updateFuncReq(FuncionarioRequisicao funcionarioRequisicao) {
        funcionarioReqRepository.save(funcionarioRequisicao);
    }

    public void removeFuncReqById(int codigo_funcreq) {
        funcionarioReqRepository.deleteById(codigo_funcreq);
    }

    public void adicionarAdmin(Administrador admin) {
        adminRepository.save(admin);
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



}
