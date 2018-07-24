package com.yangyang.service.impl;

import com.yangyang.dto.User;
import com.yangyang.service.UserService;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/7/22.
 */
@Service
public class UserServiceImpl implements UserService{
    @Override
    public boolean login(User user) {
        if("yangyang".equals(user.getName()))
            return true;
        else
            return false;
    }
}
