package com.jb.copass.service;/*
 *Created by User in 7/24/2022
 */

import com.jb.copass.beans.Coupon;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.CouponSystemException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface CustomerService {

    void purchaseCoupon(int customerId,int couponId);
    List<Coupon> getCustomerCoupons(int customerID) throws CouponSystemException ;
    List<Coupon> getCustomerCoupons(int customerID, int categoryID) throws CouponSystemException;
    List<Coupon> getCustomerCoupons(int customerID, double maxPrice) throws CouponSystemException;
    Customer getCustomerDetails(int customerID) throws CouponSystemException;

    boolean isCustomerCouponExists(int customerID, int CouponID ) throws CouponSystemException;

}
