package com.architech.demo.controller;

import com.architech.demo.Model.User;
import com.architech.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String login(Model model) {
        System.out.println("im in my login!");
        return "welcome";
    }

    @PostMapping
    public String createUser(@ModelAttribute User user, Map<String, Object> model) {
        System.out.println(user.getPassword());

        if (user.getUsername() == null
                || user.getUsername().length() < 5 ||
                !user.getUsername().matches("[a-zA-Z0-9]+")) {
            model.put("message", "username did not meet criteria");
        } else if (user.getPassword() == null ||
                user.getPassword().length() < 8
                || !user.getPassword().matches("(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).*")) {
            model.put("message", "password did not meet criteria");

        } else {
            model.put("message", userService.createUser(user));
        }
        return "result";
    }
}
