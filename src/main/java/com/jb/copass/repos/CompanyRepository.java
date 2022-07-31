package com.jb.copass.repos;/*
 *Created by User in 7/17/2022
 */

import com.jb.copass.beans.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CompanyRepository extends JpaRepository<Company,Integer> {

    //void addCompany(Company company);
    //void updateCompany(int companyId,Company company);
    // void deleteCompany(int companyId);
    //@Query(value = "SELECT exists (SELECT * FROM `bhp-coupon-system`.customers where email = ?1 and password=?2 ) as res;",nativeQuery = true)
    boolean existsByEmailAndPassword(String  email, String password);

    //@Query(value = "SELECT exists (SELECT * FROM `bhp-coupon-system`.customers where email = ?1 ) as res;",nativeQuery = true)
    boolean existsByEmail(String  email);

    //@Query(value = "SELECT exists (SELECT * FROM `bhp-coupon-system`.customers where name = ?1 ) as res;",nativeQuery = true)
    boolean existsByName(String  name);

    @Query(value = "SELECT * FROM `bhp-coupon-system`.customers where email = ?1 and password=?2 Limit 1;",nativeQuery = true)
    Company findByEmailAndPassword(String  email, String password);

}
