package com.chiyi.user.web.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginHandler {
    @RequestMapping("/login.do")
    public String login(String account,String password){
        System.out.println("我竟来了");
        return "index";
    }
}
