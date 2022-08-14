package com.jb.copass.service;/*
 *Created by User in 8/14/2022
 */

import java.util.UUID;

public interface WelcomeService {

    void register(String email,String password) throws Exception;
    UUID login(String email,String password);
}
