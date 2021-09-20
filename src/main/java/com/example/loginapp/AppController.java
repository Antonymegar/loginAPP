package com.example.loginapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class AppController {
    @Autowired
    private UserRepository repo;

    @GetMapping("")
    public String GetHomePage(){
        return "index";
    }
    @GetMapping("/register")
        public String showUserForm(Model model){
            model.addAttribute("user", new User());
            return "signup_form";
    }
    @PostMapping("/process_register")
    public String  addUser(User user){
        repo.save(user);
        return "register_success";
    }

}
