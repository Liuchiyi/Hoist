package com.chiyi.user.web.handler;

import com.chiyi.user.entity.UserEntity;
import com.chiyi.user.function.UserFunction;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
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

    final static String hashAlgorithmName = "MD5";
    final static int hashIterations = 1024;

    @RequestMapping(value = "/login")
    @ResponseBody
    public String login(String account, String password, HttpServletRequest request){
//        try {
////            System.out.println("开始："+System.currentTimeMillis());
//            UserEntity user=fun.login(account,password);
//            HttpSession session = request.getSession();
//            session.setAttribute("currentUser",user);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "error";
//        }
//        return "success";

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);
        try {
            subject.login(token);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }

    }


    @RequestMapping("/register")
    @ResponseBody
    public String register(String account, String name,String email, String password){
        ByteSource credentialsSalt = ByteSource.Util.bytes(account); //盐
        String passwordMD5 = new SimpleHash(hashAlgorithmName, password, credentialsSalt, hashIterations).toString();//密码MD5加密
        try {
             fun.register(account,name,passwordMD5,email);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }



    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "index";
    }

    @RequestMapping("/admin")
    public String admin(HttpServletRequest request){
        return "success";
    }

    @RequestMapping("/student")
    public String student(HttpServletRequest request){
        return "success";
    }

    @RequestMapping("/teacher")
    public String teacher(HttpServletRequest request){
        return "success";
    }

}
