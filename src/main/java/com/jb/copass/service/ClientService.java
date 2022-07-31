package com.jb.copass.service;/*
 *Created by User in 7/24/2022
 */

import com.jb.copass.repos.CompanyRepository;
import com.jb.copass.repos.CouponRepository;
import com.jb.copass.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public abstract class ClientService {

    @Autowired
    protected CustomerRepository customerRepository;
    @Autowired
    protected CompanyRepository companyRepository;
    @Autowired
    protected CouponRepository couponRepository;

    public abstract boolean login(String email, String password);

}
