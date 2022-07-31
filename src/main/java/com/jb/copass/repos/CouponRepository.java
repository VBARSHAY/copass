package com.jb.copass.repos;/*
 *Created by User in 7/17/2022
 */

import com.jb.copass.beans.Coupon;
import com.jb.copass.beans.Customer;
import com.jb.copass.exceptions.CouponSystemException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon,Integer> {

    //void addCoupon(Coupon coupon) throws CouponSystemException;
    //void updateCoupon(Integer couponId, Coupon coupon) throws CouponSystemException;
    //void deleteCoupon(Integer couponId) throws CouponSystemException;
    //void deleteCouponCompany(Integer companyId) throws  CouponSystemException;
    //ArrayList<Coupon> getAllCoupons() throws CouponSystemException;
    //Coupon getOneCoupon(Integer couponID) throws CouponSystemException;
    @Query(value = "Insert into `bhp-coupon-system`.customers_coupons(`customer_id`,`coupons_id`) Values(?1,?2)",nativeQuery = true)
    void purchaseCoupon(int customerId , int couponId);

    @Query(value = "SELECT * FROM `bhp-coupon-system`.`coupons` join `bhp-coupon-system`.`customers_coupons` ON `bhp-coupon-system`.`coupons`.id=`bhp-coupon-system`.`customers_coupons`.coupons_id Where `bhp-coupon-system`.`customers_coupons`.customer_id = ?1;",nativeQuery = true)
    List<Coupon> getCustomerCoupons(int customerID);

    @Query(value = "SELECT `bhp-coupon-system`.customers_coupons.* FROM `bhp-coupon-system`.coupons join `bhp-coupon-system`.customers_coupons ON `bhp-coupon-system`.coupons.id=`bhp-coupon-system`.customers_coupons.customer_id Where `bhp-coupon-system`.customers_coupons.customer_id = ?1 and `bhp-coupon-system`.customers_coupons.coupons_id=?2;",nativeQuery = true)
    List<Coupon> getCustomerCoupons(int customerID,int categoryID);

    @Query(value = "SELECT `bhp-coupon-system`.coupons.* from `bhp-coupon-system`.coupons join `bhp-coupon-system`.customers_coupons ON `bhp-coupon-system`.coupons.id=`bhp-coupon-system`.customers_coupons.coupons_id Where `bhp-coupon-system`.customers_coupons.customer_id = ?1 and `bhp-coupon-system`.coupons.price <= ?2;",nativeQuery = true)
    List<Coupon> getCustomerCoupons(int customerID, double maxPrice);

    @Modifying
    @Transactional
    @Query(value ="delete FROM `bhp-coupon-system`.coupons where end_date < CURDATE() ;",nativeQuery = true)
    void deleteExpiredCoupon() throws CouponSystemException;

    @Query(value = "SELECT * FROM `bhp-coupon-system`.customers where customers.id = ?1;" , nativeQuery = true)
    Customer getCustomerDetails(int customerID);


//    Coupon findByCompanyTitle(int CompanyID, String  title) throws CouponSystemException;
//    ArrayList<Coupon> getAllByCompany(int companyID) throws CouponSystemException;
//    ArrayList<Coupon> getAllByCompanyCategory(int companyID, int categoryID) throws CouponSystemException;
//    ArrayList<Coupon> getAllByCompanyMaxPrice(int companyID, double maxPrice) throws CouponSystemException;
//    ArrayList<Coupon> getAllByCustomer(int customerID) throws CouponSystemException ;
//    ArrayList<Coupon> getAllByCustomerCategory(int customerID, int categoryID) throws CouponSystemException;
//    ArrayList<Coupon> getAllByCustomerMaxPrice(int customerID, double maxPrice) throws CouponSystemException;
//    boolean isCustomerCouponExists(int customerID, int CouponID ) throws CouponSystemException;

}
