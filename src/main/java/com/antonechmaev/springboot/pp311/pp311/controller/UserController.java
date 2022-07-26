package com.antonechmaev.springboot.pp311.pp311.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/user")
    public String getUserInfo() {

        return "user";
    }

}
