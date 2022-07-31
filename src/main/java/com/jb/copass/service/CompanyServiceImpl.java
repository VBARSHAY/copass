package com.jb.copass.service;/*
 *Created by User in 7/24/2022
 */

import com.jb.copass.beans.Company;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.CouponSystemException;
import com.jb.copass.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl extends  ClientService implements CompanyService{
    @Override
    public boolean login(String email, String password) {
        if(email.equals("deco@mail.com") && password.equals("dc@dc"))
        {
            System.out.println("T");
            return true;
        }
        System.out.println("F");
        return false;
    }

    @Override
    public boolean existsByEmailAndPassword(String email, String password) {
        return  companyRepository.existsByEmailAndPassword(email,password);
    }

    @Override
    public boolean existsByEmail(String email) {
        return  companyRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByName(String name) {
        return  companyRepository.existsByName(name);
    }

    @Override
    public Company findByEmailAndPassword(String email, String password) {
        return  companyRepository.findByEmailAndPassword(email,password);
    }
}
