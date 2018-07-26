package com.yangyang.aop.service.impl;

import com.yangyang.dto.Role;
import com.yangyang.aop.service.RoleService;
import org.springframework.stereotype.Service;


/**
 * Created by yangyang on 2018/7/26.
 */
public class RoleServiceImpl implements RoleService {
    @Override
    public void printRole(Role role) {
        //把 printRole 作为 AOP 的切点 ， 那么用动态代理的语言就是要为类 RoleServicelmpl 生成代理对象 ， 然后拦截 printRole 方法，于是可以产生各种 AOP 通知方法。
        System.out.println("id:" + role.getId() + "  roleName:" + role.getRoleName() + "  Note:" + role.getNote());
    }
}
