package com.jb.copass.controllers;/*
 *Created by User in 8/14/2022
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/auth")
public class AuthController {

    @GetMapping("hi")
    public String hi(@RequestHeader("Authorization") UUID token){
        return "Hello world";
    }
}

