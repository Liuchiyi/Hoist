package com.chiyi.user.web.handler;


import com.chiyi.user.entity.MotorEntity;
import com.chiyi.user.function.MotorFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/motorSearch")
public class MotorHandler {

    @Autowired
    MotorFunction motorFunction;

    @RequestMapping(value = "/searchMotor", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<MotorEntity> searchMotor() {
        List<MotorEntity> ret = null;
        try {
            ret =  motorFunction.motorSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(value = "/searchMotorById", produces = "application/json;charset=utf-8")
    @ResponseBody
    public MotorEntity searchMotorById(String motorId, HttpSession session) {
        MotorEntity ret = null;
        try {
            ret =  motorFunction.motorSearchById(motorId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret == null){
            return new MotorEntity();
        }
        return ret;
    }

}
