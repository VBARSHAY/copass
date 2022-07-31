package com.jb.copass.clr;/*
 *Created by User in 7/17/2022
 */

import com.jb.copass.beans.Category;
import com.jb.copass.beans.Customer;
import com.jb.copass.beans.Coupon;
import com.jb.copass.beans.Company;
import com.jb.copass.repos.CompanyRepository;
import com.jb.copass.repos.CouponRepository;
import com.jb.copass.repos.CustomerRepository;
import com.jb.copass.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;

//import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;

@Component
@Order(1)
public class RepositoryInit implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public void run(String... args) throws Exception {


        Print.printCaption("Add 5 customers");
        Customer cust1 = Customer.builder()
                .firstName("Vladimir")
                .lastName("Bar Shay")
                .password("vb@vb")
                .email("vladi@mail.com")
                .build();
        Customer cust2 = Customer.builder()
                .firstName("Gilad")
                .lastName("Or Zah")
                .password("go@go")
                .email("gilad@mail.com")
                .build();
        Customer cust3 = Customer.builder()
                .firstName("Ohad")
                .lastName("Stain")
                .password("os@os")
                .email("ohad@mail.com")
                .build();
        Customer cust4 = Customer.builder()
                .firstName("Lior")
                .lastName("Lulu")
                .password("ll@ll")
                .email("lior@mail.com")
                .build();
        Customer cust5 = Customer.builder()
                .firstName("Ioni")
                .lastName("Katz")
                .password("ik@ik")
                .email("ioni@mail.com")
                //.coupons(Arrays.asList(co1,co2))
                .build();

        Print.printCaption("All Customers was Added");
        customerRepository.saveAll(Arrays.asList(cust1,cust2,cust3,cust4,cust5));
        customerRepository.findAll().forEach(System.out::println);

        Print.printCaption("Add 5 companies");
        Company comp1 = Company.builder()
                .name("MatriXX")
                .email("matrixx@gmail.com")
                .password("mx@mx")
                .build();

        Company comp2 = Company.builder()
                .name("ShemCo")
                .email("shemco@gmail.com")
                .password("sh@sh")
                .build();
        Company comp3 = Company.builder()
                .name("DraftCo")
                .email("DraftCo@gmail.com")
                .password("dr@dr")
                .build();
        Company comp4 = Company.builder()
                .name("ionicTech")
                .email("ionicTech@gmail.com")
                .password("io@io")
                .build();
        Company comp5 = Company.builder()
                .name("BuzzGift")
                .email("BuzzGif@gmail.com")
                .password("bg@bg")
                .build();

        Print.printCaption("Add 5 coupons");
        Coupon cou1 = Coupon.builder()
                .company(comp1)
                .category(Category.ENTERTAINMENT)
                .title("10% less for evening event in Zappa")
                .description("Only in Jerusalem district ! 10% less for evening event in Zappa")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(1)))
                .amount(100)
                .price(10)
                .image("https://picsum.photos/200/300\n")
                .build();
        Coupon cou2 = Coupon.builder()
                .company(comp2)
                .category(Category.PC)
                .title("15% less for mouses and keyboards in KSP")
                .description("Only in Eilat district ! 15% less for mouses and keyboards in KSP")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(2)))
                .amount(25)
                .price(20)
                .image("https://picsum.photos/200/300\n")
                .build();

        Coupon cou3 = Coupon.builder()
                .company(comp3)
                .category(Category.FOOD)
                .title("5% less for Barillas pasta")
                .description("Only in BeerSheva district ! 5% less for Barillas pasta")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(3)))
                .amount(1000)
                .price(15)
                .image("https://picsum.photos/200/300\n")
                .build();
        Coupon cou4 = Coupon.builder()
                .company(comp4)
                .category(Category.MARKET)
                .title("100 sheqel discount for order in PlayMarket in order more than 500 nis")
                .description("Only in Haifa district ! 100 sheqel discount for order in PlayMarket in order more than 500 nis")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(3)))
                .amount(200)
                .price(100)
                .image("https://picsum.photos/200/300\n")
                .build();
        Coupon cou5 = Coupon.builder()
                .company(comp5)
                .category(Category.TRAVEL)
                .title("11% less for every order in ISSTA")
                .description("Only in Tel Aviv district ! 11% less for every order in ISSTA")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(2)))
                .amount(50)
                .price(99)
                .image("https://picsum.photos/200/300\n")
                .build();
        Coupon cou6 = Coupon.builder()
                .company(comp5)
                .category(Category.TRAVEL)
                .title("7% less for every order in ISSTA")
                .description("Only in Tel Aviv district ! 7% less for every order in ISSTA")
                .startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().minusWeeks(2)))
                .amount(500)
                .price(10)
                .image("https://picsum.photos/200/300\n")
                .build();

        comp1.setCoupons(Arrays.asList(cou1));
        comp2.setCoupons(Arrays.asList(cou2));
        comp3.setCoupons(Arrays.asList(cou3));
        comp4.setCoupons(Arrays.asList(cou4));
        comp5.setCoupons(Arrays.asList(cou5));
        comp1.setCoupons(Arrays.asList(cou6));

        Print.printCaption("All Companies was Added with one coupon for each company");
        companyRepository.saveAll(Arrays.asList(comp1,comp2,comp3,comp4,comp5));
        companyRepository.findAll().forEach(System.out::println);

    }
}
