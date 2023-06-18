package com.example.demo.controller;

import com.example.demo.beans.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


//public class RegistrationController{}
@Controller
@RequestMapping("/register")
public class RegistrationController {
    @Autowired
    private UserRepository userRepo;
    private PasswordEncoder passwordEncoder;

//    public RegistrationController(
//            UserRepository userRepo, PasswordEncoder passwordEncoder) {
//        this.userRepo = userRepo;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public RegistrationController(
//            UserRepository userRepo) {
//        this.userRepo = userRepo;
//    }

    @GetMapping
    public String registerForm() {
        return "registration";
    }
//    @PostMapping
//    public String processRegistration() {
//        //userRepo.save(form.toUser(passwordEncoder));
////        user.encode(passwordEncoder);
////        userRepo.save(user);
//        return "redirect:/login";
//    }
    @PostMapping
    public String processRegistration(User user) {
        //userRepo.save(form.toUser(passwordEncoder));
//        user.encode(passwordEncoder);
//        userRepo.save(user);
        return "redirect:/login";
    }

}