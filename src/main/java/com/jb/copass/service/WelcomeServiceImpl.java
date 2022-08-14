package com.jb.copass.service;
import org.springframework.stereotype.Service;
import java.util.UUID;
/*
 *Created by User in 8/14/2022
 */

@Service
public class WelcomeServiceImpl implements WelcomeService{
    @Override
    public void register(String email, String password) throws Exception {

        if(false){
            throw new Exception("Sorry Email already exist");
        }
        System.out.println("Imagine that i added this user into the data base");
    }

    @Override
    public UUID login(String email, String password) {
        System.out.println("Imagine that i found email and password correct");

        return UUID.randomUUID();
    }
}
