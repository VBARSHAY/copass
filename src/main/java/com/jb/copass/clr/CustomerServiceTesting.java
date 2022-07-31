package com.jb.copass.clr;/*
 *Created by User in 7/31/2022
 */

import ch.qos.logback.core.joran.conditional.ElseAction;
import com.jb.copass.beans.Category;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.ErrMsg;
import com.jb.copass.service.CompanyService;
import com.jb.copass.service.CustomerService;
import com.jb.copass.utils.Print;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class CustomerServiceTesting implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;


    @Override
    public void run(String... args) throws Exception {

        int coupon_Id = 7;
        int customer_Id = 6;
        Print.printCaption("Get all coupons for customer  #4");
        //customerService.getCustomerCoupons(customer_Id).forEach(System.out::println);
        boolean a= customerService.isCustomerCouponExists(customer_Id,coupon_Id);
        if (a){
            Print.printCaption("customer coupon  #7 Exist");
        }
        else{
            Print.printCaption("customer coupon  #7 does not Exist");
        }
        Print.printCaption("Get all customer details for customer  #4");
//        customerService.getCustomerDetails(customer_Id).;
        Customer customer =  customerService.getCustomerDetails(customer_Id);
        if (customer != null) {
            Print.printCaption("Get details for customer " + customer.getFirstName() + " #7");
        }
        else {
            Print.printCaption("ErrMsg.CUSTOMER_NOT_FOUND");
        }
        //Print.printCaption("Get all customer details for customer  #4");
       // customerService.getCustomerCoupons(customer_Id, 1).forEach(System.out::println);

        Print.printCaption("Add coupon #3 to customer #4");
        try {
           // customerService.purchaseCoupon(customer_Id, coupon_Id);
            Print.printCaption("Coupon #3 was successfuly Addded to customer #3");
        }
        catch (Exception ex){
            Print.printCaption("Failed ,add Coupon #3 to customer #3");
        }
       // customerService.getCustomerCoupons(customer_Id).forEach(System.out::println);

    }
}
