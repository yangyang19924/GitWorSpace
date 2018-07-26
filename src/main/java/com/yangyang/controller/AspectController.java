package com.yangyang.controller;

import com.yangyang.aop.service.RoleService;
import com.yangyang.aop.service.impl.RoleServiceImpl;
import com.yangyang.dto.Role;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by yangyang on 2018/7/26.
 */
public class AspectController {


//    static RoleService roleService;
//
//    @Autowired(required = true)
//    public void setUserAccessor(RoleService roleService) {
//        AspectController.roleService = roleService;
//    }

    public static void main(String[] args) {
        Role role = new Role();
        role.setId(1);
        role.setNote("11");
        role.setRoleName("yangyang");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        RoleService roleService = (RoleService) context.getBean("roleService");
        roleService.printRole(role);
        System.out.println("##############################");

//        role = null;
//        roleService.printRole(role);


    }
}
