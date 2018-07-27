package com.chiyi.user.web.handler;

import com.chiyi.user.entity.UserEntity;
import com.chiyi.user.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginHandler {

    @Autowired
    UserFunction fun;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String account, String password, HttpServletRequest request){
        try {
//            System.out.println("开始："+System.currentTimeMillis());
            UserEntity user=fun.login(account,password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }


    @RequestMapping("/register")
    @ResponseBody
    public String register(String account, String name,String email, String password){
        try {
             fun.register(account,name,password,email);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }



}
