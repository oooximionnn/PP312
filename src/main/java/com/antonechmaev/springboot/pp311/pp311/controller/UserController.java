package com.antonechmaev.springboot.pp311.pp311.controller;

import com.antonechmaev.springboot.pp311.pp311.service.UserService;
import com.antonechmaev.springboot.pp311.pp311.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;
    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping()
    public String getUser(Model model, Principal principal) {
        model.addAttribute("user", userServiceImpl.findUserByUsername(principal.getName()));
        return "user";
    }

}
