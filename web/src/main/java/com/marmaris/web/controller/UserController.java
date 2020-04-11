package com.marmaris.web.controller;

import com.marmaris.persistence.dto.UserDto;
import com.marmaris.persistence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {


    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String homePage(Model model) {
        return "home";
    }

    @GetMapping("/user")
    public String user(Model model) {
        UserDto userDto = userService.findById(1L);
        return "home";
    }


}

