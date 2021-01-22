package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.model.Administrador;
import com.example.accessingdatamysql.model.Requisicao;
import com.example.accessingdatamysql.responseRequestBodies.Login;
import com.example.accessingdatamysql.responseRequestBodies.UserCount;
import com.example.accessingdatamysql.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
@RequestMapping("/api/admin")
public class AdminController {


    @Autowired
    public AdminService adminService;


    @PostMapping("/userCount")
    @ResponseBody
    public UserCount getUserCount(@RequestBody @NonNull Login login) {
        boolean isAdmin = adminService.isAdmin(login.contacto, login.password);
        if (isAdmin) return adminService.getUserCount();
        return null;
    }

    @PostMapping("/consCount")
    @ResponseBody
    public ArrayList<HashMap<String, Integer>> getConsCount(@RequestBody @NonNull Login login) {
        boolean isAdmin = adminService.isAdmin(login.contacto, login.password);
        if (isAdmin) return adminService.getConsCount();
        return null;
    }

    @PostMapping("/allReq")
    @ResponseBody
    public ArrayList<Requisicao> getAllReq(@RequestBody @NonNull Login login) {
        boolean isAdmin = adminService.isAdmin(login.contacto, login.password);
        if(isAdmin) return adminService.getAllReq();
        return null;
    }
}
