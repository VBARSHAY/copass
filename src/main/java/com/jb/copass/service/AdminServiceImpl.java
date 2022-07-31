package com.jb.copass.service;/*
 *Created by User in 7/24/2022
 */

import com.jb.copass.beans.Company;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.CouponSystemException;
import com.jb.copass.exceptions.ErrMsg;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminServiceImpl extends ClientService implements AdminService{


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
    public void addCompany(Company company) throws CouponSystemException {
        if (companyRepository.existsByName(company.getName())) {
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_ALREADY_EXIST);
        }
        if (companyRepository.existsByEmail(company.getEmail())) {
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_ALREADY_EXIST);
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(int companyId , Company company) throws CouponSystemException {
        Company companyOne = companyRepository.findById(companyId).orElseThrow(()->new CouponSystemException((ErrMsg.COMPANY_NOT_FOUND)));
        if (!companyOne.getName().equals(company.getName())) {
            throw new CouponSystemException(ErrMsg.COMPANY_NAME_NOT_UPDATABLE);
        }
        if (!company.getEmail().equals(company.getEmail())) {
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_NOT_UPDATABLE);
        }
        companyRepository.save(company);
    }

    public void deleteCompany(int companyId) throws CouponSystemException {
       Company companyOne = companyRepository.findById(companyId).orElseThrow(()->new CouponSystemException(ErrMsg.COMPANY_NOT_FOUND));
       companyRepository.deleteById(companyId);
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Company getOneCompany(int companyId) throws CouponSystemException {
        return companyRepository.findById(companyId).orElseThrow(()->new CouponSystemException(ErrMsg.COMPANY_NOT_FOUND));
     }

    public void addCustomer(Customer customer) throws CouponSystemException {
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new CouponSystemException(ErrMsg.CUSTOMER_EMAIL_ALREADY_EXIST);
        }
        customerRepository.save(customer);
    }

    @Override
    public void updateCustomer(int customerId, Customer customer) throws CouponSystemException {
        Customer customerOne = customerRepository.findById(customerId).orElseThrow(()->new CouponSystemException((ErrMsg.CUSTOMER_NOT_FOUND)));
        if (!customerOne.getEmail().equals(customer.getEmail())) {
            throw new CouponSystemException(ErrMsg.COMPANY_EMAIL_NOT_UPDATABLE);
        }
        customerRepository.saveAndFlush(customerOne);
    }


    public void deleteCustomer(int customerId) throws CouponSystemException {
        Customer customerOne = customerRepository.findById(customerId).orElseThrow(()->new CouponSystemException((ErrMsg.CUSTOMER_NOT_FOUND)));
        customerRepository.deleteById(customerId);
    }

    public List<Customer> getAllCustomers() throws CouponSystemException {
        return customerRepository.findAll();
    }

    public Customer getOneCustomer(Integer customerId) throws CouponSystemException {

        return customerRepository.findById(customerId).orElseThrow(()->new CouponSystemException(ErrMsg.CUSTOMER_NOT_FOUND));
    }
}
