package com.chiyi.user.web.handler;


import com.chiyi.user.entity.MotorEntity;
import com.chiyi.user.entity.TestRecordEntity;
import com.chiyi.user.function.MotorFunction;
import com.chiyi.user.function.TestRecordFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/testSearch")
public class TestRecordHandler {

    @Autowired
    TestRecordFunction testRecordFunction;

    @RequestMapping(value = "/searchTest", produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<TestRecordEntity> searchTest() {
        List<TestRecordEntity> ret = null;
        try {
            ret =  testRecordFunction.testRecordSearch();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ret;
    }

    @RequestMapping(value = "/searchTestById", produces = "application/json;charset=utf-8")
    @ResponseBody
    public TestRecordEntity searchTestById(String testId, HttpSession session) {
        TestRecordEntity ret = null;
        try {
            ret =  testRecordFunction.testRecordSearchById(testId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(ret == null){
            return new TestRecordEntity();
        }
        return ret;
    }

}
