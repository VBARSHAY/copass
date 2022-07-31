package com.jb.copass.beans;/*
 *Created by User in 7/17/2022
 */

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

@Entity
@Table(name="coupons")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @ToString.Exclude
    private Company company;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Column(length = 300,nullable = false)
    private String title;
    private String description;
    private Date startDate;
    private Date endDate;
    private int amount;
    private double price;
    private String image;
}
