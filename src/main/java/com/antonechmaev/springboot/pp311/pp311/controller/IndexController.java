package com.antonechmaev.springboot.pp311.pp311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String getIndexPage(){
        return "index";
    }
}
