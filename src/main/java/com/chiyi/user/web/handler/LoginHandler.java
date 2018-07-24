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
            UserEntity user=fun.login(account,password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/index.do")
    public String index(){
        return "testSearch";
    }

    @RequestMapping("/register.do")
    public String register(String account, String name,String email, String password, HttpServletRequest request){
        try {
            boolean flag = fun.register(account,name,password,email);
            if(flag) request.setAttribute("message","用户注册成功");
            else request.setAttribute("message","用户注册失败，请重新注册");
        } catch (Exception e) {
            request.setAttribute("message",e.getMessage());

        }
        return "forward:/login/register.jsp";
    }

    @RequestMapping("/registerpage.do")
    public String registerpage(){
        return "forward:/login/register.jsp";
    }

    @RequestMapping("/loginpage.do")
    public String loginpage(){
        return "forward:/login/login.jsp";
    }

}
