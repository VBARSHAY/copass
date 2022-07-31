package com.jb.copass.service;/*
 *Created by User in 7/24/2022
 */

import com.jb.copass.beans.Company;

public interface CompanyService {

    boolean existsByEmailAndPassword(String  email, String password);
    boolean existsByEmail(String  email);
    boolean existsByName(String  name);
    Company findByEmailAndPassword(String  email, String password);

}
