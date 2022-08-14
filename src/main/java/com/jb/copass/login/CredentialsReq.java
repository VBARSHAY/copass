package com.jb.copass.login;/*
 *Created by User in 8/14/2022
 */

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CredentialsReq {

    private String email;
    private String password;
}
