package com.jb.copass.clr;/*
 *Created by User in 7/24/2022
 */

import com.jb.copass.beans.Category;
import com.jb.copass.beans.Company;
import com.jb.copass.beans.Coupon;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.CouponSystemException;
import com.jb.copass.service.AdminService;
import com.jb.copass.service.CompanyService;
import com.jb.copass.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

@Component
@Order(2)
public class AdminServiceTesting implements CommandLineRunner {

    @Autowired
    private AdminService adminService;

    @Override
    public void run(String... args) throws Exception {

        Print.printCaption("Add company");
        Company company = Company.builder()
                .name("Deco & Son Co.")
                .password("dc@dc")
                .email("deco@mail.com")
                .coupon(Coupon.builder()
                        .category(Category.PC)
                        .title("11% less for routers from Deco")
                        .description("Only in august! 11% less for Deco routers!")
                        .price(200)
                        .amount(88)
                        .startDate(Date.valueOf(LocalDate.now()))
                        .endDate(Date.valueOf(LocalDate.now().plusMonths(2)))
                        .image("https://picsum.photos/200/300\n")
                        .build())
                        .build();
        adminService.addCompany(company);
        Print.printCaption("All Companies include new DECO");
        adminService.getAllCompanies().forEach(System.out::println);

        Print.printCaption("Add company with exists email");
        Company company1 = Company.builder()
                .name("Deco & Son Co.")
                .password("dc@dc")
                .email("deco@mail.com")
                .coupon(Coupon.builder()
                        .category(Category.PC)
                        .title("11% less for routers from Deco")
                        .description("Only in august! 11% less for Deco routers!")
                        .price(200)
                        .amount(88)
                        .startDate(Date.valueOf(LocalDate.now()))
                        .endDate(Date.valueOf(LocalDate.now().plusMonths(2)))
                        .image("https://picsum.photos/200/300\n")
                        .build())
                .build();
        try {
            adminService.addCompany(company);
        }
        catch (Exception e)
        {
            Print.printCaption(e.getMessage());
        }
        Print.printCaption("All Companies include new DECO");
        adminService.getAllCompanies().forEach(System.out::println);

        Print.printCaption("Update company");
        Integer compId = 6;
        company.setPassword("deco@deco");
        adminService.updateCompany(6, company);
        adminService.getAllCompanies().forEach(System.out::println);

        Print.printCaption("Delete company");
        adminService.deleteCompany(compId);
        adminService.getAllCompanies().forEach(System.out::println);

        Print.printCaption("Get All Companies");
        adminService.getAllCompanies().forEach(System.out::println);

        Print.printCaption("Get One Company");
        System.out.println(adminService.getOneCompany(compId-1));

        Print.printCaption("Add customer");
        Customer customer = Customer.builder()
                .firstName("Dennis")
                .lastName("Frick")
                .password("df@df")
                .email("dennis@mail.com")
                .coupon(Coupon.builder()
                        .category(Category.FOOD)
                        .title("17% less for Mini cornflakes")
                        .description("Only in august! 17% less for Mini cornflakes!")
                        .price(15.90)
                        .amount(300)
                        .startDate(Date.valueOf(LocalDate.now()))
                        .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                        .image("https://picsum.photos/200/300\n")
                        .build())
                .build();
        adminService.addCustomer(customer);
        Print.printCaption("All Customers include new Dennis");
        adminService.getAllCustomers().forEach(System.out::println);

        Integer custId = 3;
        Customer cust3 = adminService.getOneCustomer(custId);
        cust3.builder()
                .firstName("Ohad Plus coupon 1")
                .email("ohh@mail.com")
                .coupon(Coupon.builder().id(1).build())
                .build();
        adminService.updateCustomer(custId,cust3);

        Print.printCaption("All Customers Ohad get coupon 1");
        adminService.getAllCustomers().forEach(System.out::println);

        adminService.deleteCustomer(adminService.getOneCustomer(5).getId());
        Print.printCaption("Delete customers Ioni");

        Print.printCaption("Get All Customers");
        adminService.getAllCustomers().forEach(System.out::println);

        Print.printCaption("Get One Customer");
        System.out.println(adminService.getOneCustomer(custId));



    }
}
