package com.ky.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Controller
@RequestMapping("/app")
public class AppController {

    @GetMapping("/index")
    public String index() {
        return "index.html";
    }

    @GetMapping("/testWebHook")
    public String test() {
        return "testWebHook111";
    }
}
