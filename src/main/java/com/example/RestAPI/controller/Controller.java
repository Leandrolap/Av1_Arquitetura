package com.example.RestAPI.controller;

import com.example.RestAPI.model.NoticiaEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.RestAPI.service.UserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private UserService service;

    @GetMapping("/noticias")
    public String preverTempo(){
        return service.preverTempo();
    }

    @GetMapping("/noticiasereleases")
    public String preverTempo1(){
        return service.preverTempo1();
    }

    @GetMapping("/releases")
    public String preverTempo2(){
        return service.preverTempo2();
    }

    @Autowired
    private UserService userService;

    @GetMapping
    public List<NoticiaEntity> obterTodos() {
        return userService.obterTodos();
    }

    @PostMapping
    public String inserir(@RequestBody NoticiaEntity user) { return userService.preverTempo(); }
}