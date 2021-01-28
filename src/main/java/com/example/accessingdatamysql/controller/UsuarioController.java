package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Administrador;
import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.FuncionarioRequisicao;
import com.example.accessingdatamysql.model.Usuario;
import com.example.accessingdatamysql.responseRequestBodies.Login;
import com.example.accessingdatamysql.responseRequestBodies.UserCount;
import com.example.accessingdatamysql.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/usuario/")
public class UsuarioController {

    @Autowired
    public UsuarioService usuarioService;

    @GetMapping("/test")
    public void test() {
        usuarioService.test();
    }

    @PostMapping("/login")
    @ResponseBody
    public Usuario login (@RequestBody @NonNull Login login) {
        Usuario user = usuarioService.findDocenteByEmail(login.contacto, login.password);
        if (user == null) user = usuarioService.findAdminByEmailPassword(login.contacto, login.password);
        if (user == null) user = usuarioService.findFuncReqByEmailPassword(login.contacto, login.password);

        return user;
    }

    @PostMapping("/adicionarDocente")
    public String adicionarDocente (@RequestBody @NonNull Docente docente) {
        try {
            usuarioService.adicionarDocente(docente);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Success";
    }

    @GetMapping("/getDocente/getAll")
    @ResponseBody
    public ArrayList<Docente> getAllDocs() {
        return usuarioService.getAllDocs();
    }

    @GetMapping("/getDocente/{codigo_docente}")
    @ResponseBody
    public Docente docente (@PathVariable int codigo_docente) {
        Optional<Docente> usuarioOptional = usuarioService.getDocenteById(codigo_docente);
        if (usuarioOptional.isPresent()) {
            return  usuarioOptional.get();
        }
        return null;
    }

    @PutMapping("/updateDocente")
    public String updateDocente (@RequestBody @NonNull Docente docente) {
        try {
            usuarioService.updateDocente(docente);
        } catch (Exception ex) {
            return ex.getMessage();
        }
        return "Success";
    }


    @DeleteMapping("/deleteDocente/{codigo_docente}")
    public String deleteDocenteById (@PathVariable int codigo_docente) {
        usuarioService.removeDocenteById(codigo_docente);
        return "Success";
    }

    @PostMapping("/adicionarFunc")
    public String adicionarFuncionarioReq(@RequestBody @NonNull FuncionarioRequisicao funcionarioRequisicao) {
        usuarioService.adicionarFuncionarioRequisicao(funcionarioRequisicao);
        return "Success";
    }

    @GetMapping("/getFuncReq/getAll")
    @ResponseBody
    public ArrayList<FuncionarioRequisicao> getAllFuncReq() {
        return usuarioService.getAllFuncReq();
    }

    @GetMapping("/getFuncReq/{codigo_funcreq}")
    public FuncionarioRequisicao getFuncReq(@PathVariable int codigo_funcreq) {
        Optional<FuncionarioRequisicao> funcReqOptional = usuarioService.getFuncReqById(codigo_funcreq);
        if (funcReqOptional.isPresent()) {
            return funcReqOptional.get();
        }
        return null;
    }

    @GetMapping("/getRandFunc")
    public FuncionarioRequisicao getRandFunc() {
        List<FuncionarioRequisicao> funcReq = usuarioService.getAllFuncReq();
        int randomIndex = (int) (Math.random() * funcReq.size());
        return funcReq.get(randomIndex);
    }

    @PutMapping("/updateFuncReq")
    public String updateFuncReq(@RequestBody FuncionarioRequisicao funcionarioRequisicao) {
        usuarioService.updateFuncReq(funcionarioRequisicao);
        return "Success";
    }

    @DeleteMapping("/deleteFuncReq/{codigo_funcreq}")
    public String deleteFuncReq(@PathVariable int codigo_funcreq) {
        usuarioService.removeFuncReqById(codigo_funcreq);
        return "Success";
    }

    @PostMapping("/addAdmin")
    public String adicionarAdmin(@RequestBody @NonNull Administrador admin) {
        usuarioService.adicionarAdmin(admin);
        return "Success";
    }


    @GetMapping("/getAdmin/getAll")
    @ResponseBody
    public ArrayList<Administrador> getAllAdmins() {
        return usuarioService.getAllAdmins();
    }

    @GetMapping("/getAdmin/{codigo_admin}")
    public Administrador getAdminById(@PathVariable int codigo_admin) {
        Optional<Administrador> adminOptional = usuarioService.getAdminById(codigo_admin);
        if(adminOptional.isPresent()) {
            return adminOptional.get();
        }
        return null;
    }

    @PutMapping("/updateAdmin")
    public String updateAdmin(@RequestBody @NonNull Administrador admin) {
        usuarioService.updateAdmin(admin);
        return "Success";
    }



    @DeleteMapping("/deleteAdmin/{codigo_admin}")
    public String deleteAdminById(@PathVariable int codigo_admin){
        usuarioService.removeAdminById(codigo_admin);
        return "Success";
    }
}
