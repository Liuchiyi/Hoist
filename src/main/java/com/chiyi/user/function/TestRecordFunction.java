package com.chiyi.user.function;

import com.chiyi.user.entity.MotorEntity;
import com.chiyi.user.entity.TestRecordEntity;

import java.util.List;


public interface TestRecordFunction {

    public List<TestRecordEntity> testRecordSearch() throws Exception;
    public TestRecordEntity testRecordSearchById(String motorId) throws Exception;


}
