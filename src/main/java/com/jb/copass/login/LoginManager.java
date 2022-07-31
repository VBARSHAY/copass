package com.jb.copass.login;
import com.jb.copass.beans.ClientType;
import com.jb.copass.service.*;
import org.springframework.stereotype.Service;
/*
 *Created by User in 7/24/2022
 */
import com.jb.copass.beans.ClientType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;


@Service
public class LoginManager {

    @Autowired
    private ApplicationContext ctx;

    public ClientService login(String email, String password, ClientType clientType){
        switch (clientType){
            case ADMIN:
                AdminService adminService = ctx.getBean(AdminService.class);
                if( ((AdminServiceImpl) adminService).login(email,password)){
                    return (ClientService) adminService;
                }
                break;
            case CUSTOMER:
                CustomerService customerService = ctx.getBean(CustomerService.class);
                if( ((AdminServiceImpl) customerService).login(email,password)){
                    return (ClientService) customerService;
                }
                break;
            case COMPANY:
                CompanyService companyService = ctx.getBean(CompanyService.class);
                if( ((AdminServiceImpl) companyService).login(email,password)){
                    return (ClientService) companyService;
                }
                break;
        }
        return null;
    }
}
