package com.jb.copass.clr;/*
 *Created by User in 7/31/2022
 */

import com.jb.copass.beans.Category;
import com.jb.copass.beans.Company;
import com.jb.copass.beans.Coupon;
import com.jb.copass.exceptions.CouponSystemException;
import com.jb.copass.exceptions.ErrMsg;
import com.jb.copass.service.AdminService;
import com.jb.copass.service.CompanyService;
import com.jb.copass.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.management.loading.ClassLoaderRepository;
import java.sql.Date;
import java.time.LocalDate;

@Component
@Order(3)
public class CompanyServiceTesting implements CommandLineRunner {

    @Autowired
    private CompanyService companyService;


    @Override
    public void run(String... args) throws Exception {

        Print.printCaption("Check If company exists by Email");
        String email = "shemco@gmail.com";
        String pasw = "sh@sh";
        if (companyService.existsByEmail(email)){
            Print.printCaption("Company with this email " + email + " alredy EXIST!");
        }
        else
        {
            Print.printCaption("Company with this email " + email + " DOES NOT EXIST!");
        }
        Print.printCaption("Check If company exists by Email & PassWord");
        if (companyService.existsByEmailAndPassword(email,pasw)){
            Print.printCaption("Company with this email " + email + " and password " + pasw + " alredy EXIST!");
        }
        else
        {
            Print.printCaption("Company with this email " + email + " and password " + pasw + " DOES NOT EXIST!");
        }

        pasw = "sha@sha";
        if (companyService.existsByEmailAndPassword(email,pasw)){
            Print.printCaption("Company with this email " + email + " and password " + pasw + " alredy EXIST!");
        }
        else
        {
            Print.printCaption("Company with this email " + email + " and password " + pasw + " DOES NOT EXIST!");
        }

        email = "Kakoplease@gmail.com";
        if (companyService.existsByEmail(email)){
            Print.printCaption("Company with this email " + email + " alredy EXIST!");
        }
        else
        {
            Print.printCaption("Company with this email " + email + " DOES NOT EXIST!");
        }

        Print.printCaption("Find company by Email & PassWord");

        Company company = companyService.findByEmailAndPassword(email,pasw);
        if (company != null){
            Print.printCaption("Company with this email " + email + " and password " + pasw + " Find Successfuly!");
        }
        else
        {
            Print.printCaption("Company with this email " + email + " and password " + pasw + " DOES NOT Find in DB!");
        }

        Print.printCaption("End company testing staff");
    }
}
