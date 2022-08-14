package com.jb.copass.controllers;/*
 *Created by User in 8/14/2022
 */
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/public")
public class PublicController {

    @GetMapping("hi")
    public String hi(){
        return "Hello world";
    }
}
