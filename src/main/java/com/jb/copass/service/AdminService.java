package com.jb.copass.service;/*
 *Created by User in 7/24/2022
 */

import com.jb.copass.beans.Company;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.CouponSystemException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface AdminService {

    void addCompany(Company company) throws CouponSystemException;
    void updateCompany(int companyId , Company company) throws CouponSystemException;
    void deleteCompany(int companyId) throws CouponSystemException;
    List<Company> getAllCompanies();
    Company getOneCompany(int companyId) throws CouponSystemException;

    void addCustomer(Customer customer) throws CouponSystemException;
    void updateCustomer(int customerId ,Customer customer) throws CouponSystemException;
    void deleteCustomer(int customerId) throws CouponSystemException;
    List<Customer> getAllCustomers() throws CouponSystemException;
    Customer getOneCustomer(Integer customerId) throws CouponSystemException;
}
