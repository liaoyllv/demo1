package com.ky.demo1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/app")
public class AppController {

    @GetMapping("/index")
    public String index() {
        return UUID.randomUUID().toString();
    }
}
