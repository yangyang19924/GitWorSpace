package com.yangyang.controller;

import com.yangyang.dto.User;
import com.yangyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2018/7/22.
 */
@Controller

@RequestMapping(value="user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping("/login")
    public String login(@RequestParam(value="name",required=false) String name,@RequestParam(value="password",required = false) String password,Model model) {

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        if(service.login(user)){

            model.addAttribute("username", user.getName());

            return "welcome";
        }else {
            model.addAttribute("error", "登陆失败");

            return "login";
        }

    }

//    @RequestMapping("/register")
//    public String register(User user,Model model) {
//
//        if(service.register(user)){
//
//            model.addAttribute("username", user.getUsername());
//
//            return "welcome";
//        }else {
//            model.addAttribute("error", "注册失败");
//
//            return "register";
//        }
//
//    }
//
//    @RequestMapping("/reset")
//    public String resetPassword(User user,Model model) {
//
//        if(service.resetPassword(user)){
//
//            model.addAttribute("username", user.getUsername());
//
//            return "welcome";
//        }else {
//            model.addAttribute("error", "重置失败");
//
//            return "reset";
//        }
//
//    }
//
//    @RequestMapping("/list")
//    public String listUsers(Model model) {
//
//        Collection<User> list = service.listUser();
//
//        model.addAttribute("list", list);
//
//        return "list";
//    }

}
