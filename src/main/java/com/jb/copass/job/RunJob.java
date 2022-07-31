package com.jb.copass.job;/*
 *Created by User in 7/31/2022
 */

import com.jb.copass.exceptions.CouponSystemException;
import com.jb.copass.repos.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;

@Component
public class RunJob {

    @Autowired
    private CouponRepository couponRepository;

    @Scheduled(fixedRate = 24*60*60*1000 )    //1000= 1second
    public void daily() throws CouponSystemException {

        System.out.println("Before->" + couponRepository.count());

        couponRepository.deleteExpiredCoupon();

        System.out.println("After -> " + couponRepository.count());

    }
}
