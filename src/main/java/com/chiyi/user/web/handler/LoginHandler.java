package com.chiyi.user.web.handler;

import com.chiyi.user.entity.UserEntity;
import com.chiyi.user.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginHandler {

    @Autowired
    UserFunction fun;

    @RequestMapping("/login.do")
    public String login(String account, String password, HttpServletRequest request){
        try {
            UserEntity user=fun.login(account,password);
            HttpSession session = request.getSession();
            session.setAttribute("currentUser",user);
        } catch (Exception e) {
            request.setAttribute("message",e.getMessage());
            return "forward:/login.jsp";
        }
        return "redirect:/index.do";
    }

    @RequestMapping("/index.do")
    public String index(){
        return "index";
    }

}
