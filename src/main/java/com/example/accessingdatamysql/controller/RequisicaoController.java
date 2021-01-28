package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Docente;
import com.example.accessingdatamysql.model.EstadoRequisicao;
import com.example.accessingdatamysql.model.Requisicao;
import com.example.accessingdatamysql.model.Usuario;
import com.example.accessingdatamysql.responseRequestBodies.GetByDate;
import com.example.accessingdatamysql.service.RequisicaoService;
import com.example.accessingdatamysql.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//http://localhost:8080/api/requisicao/criarRequi

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/requisicao") // http://localhost:8080/api/requisicao
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
    public Requisicao getRequestByCodigo(@PathVariable int codigo_requisicao) {
        Optional<Requisicao> requisicaoOptional = requisicaoService.getReqById(codigo_requisicao);
        if (requisicaoOptional.isPresent()) {
            return requisicaoOptional.get();
        }
        return null;
    }

    @PostMapping("/getByDoc")
    @ResponseBody
    public List<Requisicao> getByCodigoDocente(@NonNull @RequestBody Docente docente) {
        return requisicaoService.getRequisicoesByCodigoDocente(docente);
    }

    @PostMapping("/getToday")
    @ResponseBody
    public List<Requisicao> getTodaysRequest(@NonNull @RequestBody GetByDate gbd) {
        return requisicaoService.getTodayRequest(gbd.getDate());
    }


    @GetMapping("/getReq/getAll")
    @ResponseBody
    public List<Requisicao> getAllRequests() {
        List<Requisicao> requisicoes = requisicaoService.getAll();
        return requisicoes;
    }


    public String update(String typeUpdate) throws Exception {
        return typeUpdate;
    }
}
