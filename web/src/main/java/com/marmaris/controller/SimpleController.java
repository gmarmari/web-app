package com.marmaris.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleController {


    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }

}
