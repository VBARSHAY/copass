package com.jb.copass.beans;/*
 *Created by User in 7/17/2022
 */
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    @Column(length = 40,nullable = false)
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @Singular
    private List<Coupon> coupons = new ArrayList<>();
}
