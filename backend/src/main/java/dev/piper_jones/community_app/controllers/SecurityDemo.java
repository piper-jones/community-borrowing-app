package dev.piper_jones.community_app.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/rest")
public class SecurityDemo {
    @GetMapping("/public")
    public String publicEndPoint() {
        return "This is a public endpoint";
    }

    @GetMapping("/admin")
    public String adminEndPoint() {
        return "This is an admin endpoint";
    }

    @GetMapping("/user")
    public String userEndPoint() {
        return "This is a user endpoint";
    }
}