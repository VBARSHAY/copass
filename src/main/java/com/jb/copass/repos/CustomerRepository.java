package com.jb.copass.repos;/*
 *Created by User in 7/17/2022
 */

import com.jb.copass.beans.Coupon;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.CouponSystemException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

   // void addCustomer(Customer customer) throws CouponSystemException;

   // void updateCustomer(Integer customerId, Customer customer) throws CouponSystemException;

   // void deleteCustomer(Integer customerId) throws CouponSystemException;

  //  ArrayList<Customer> findAllCustomers() throws  CouponSystemException;

  //  Customer findOneCustomer(Integer customerId) throws CouponSystemException;


    boolean existsByEmail(String email) throws CouponSystemException;

}
