package com.jb.copass.beans;/*
 *Created by User in 7/17/2022
 */

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="companies")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50,nullable = false)
    private String name;
    @Column(length = 50,nullable = false)
    private String email;
    @Column(length = 50,nullable = false)
    private String password;

    //@OneToMany
    //@OneToMany(cascade = CascadeType.PERSIST)
    @OneToMany(cascade = CascadeType.PERSIST,orphanRemoval = true)
    @Singular
    private List<Coupon> coupons = new ArrayList<>();
}
