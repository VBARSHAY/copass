package com.jb.copass.service;/*
 *Created by User in 7/24/2022
 */

import com.jb.copass.beans.Coupon;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.CouponSystemException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CustomerServiceImpl extends ClientService implements CustomerService{


    @Override
    public boolean login(String email, String password) {
        if(email.equals("vladi@mail.com") && password.equals("vb@vb"))
        {
            System.out.println("T");
            return true;
        }
        System.out.println("F");
        return false;
    }

    @Override
    public void purchaseCoupon(int customerId,int couponId) {
        this.couponRepository.purchaseCoupon(customerId,couponId);
    }

    @Override
    public List<Coupon> getCustomerCoupons(int customerID) throws CouponSystemException {
        return couponRepository.getCustomerCoupons(customerID);
    }

    @Override
    public List<Coupon> getCustomerCoupons(int customerID, int categoryID) throws CouponSystemException {
        return couponRepository.getCustomerCoupons(customerID,categoryID);
    }

    @Override
    public List<Coupon> getCustomerCoupons(int customerID, double maxPrice) throws CouponSystemException {
        return couponRepository.getCustomerCoupons(customerID,maxPrice);
    }

    public Customer getCustomerDetails(int customerID) throws CouponSystemException {
        return couponRepository.getCustomerDetails(customerID);
    }

    @Override
    public boolean isCustomerCouponExists(int customerID, int CouponID) throws CouponSystemException {
        return false;
    }
}
