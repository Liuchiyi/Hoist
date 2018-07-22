package com.chiyi.user.function.impl;

import com.chiyi.common.ThisSystemException;
import com.chiyi.user.dao.TestRecordDao;
import com.chiyi.user.entity.TestRecordEntity;
import com.chiyi.user.function.TestRecordFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class TestRecordFunctionImpl implements TestRecordFunction {


    @Autowired
    TestRecordDao testRecordDao;



    @Override
    public List<TestRecordEntity> testRecordSearch() throws Exception{

        List<TestRecordEntity> testRecordList =  testRecordDao.selectAll();
        if(testRecordList == null){
            throw new ThisSystemException("无记录！！！");
        }else {
            for(Iterator<TestRecordEntity> iterator = testRecordList.iterator(); iterator.hasNext();){
                iterator.next().setTestDateStr();
            }
        }
        return testRecordList;
    }

    @Override
    public TestRecordEntity testRecordSearchById(String testId) throws Exception{
        TestRecordEntity testRecord = (TestRecordEntity)testRecordDao.selectBySth("id",testId);
        if(testRecord == null){
            throw new ThisSystemException("该测试记录不存在");
        }
        else {
            testRecord.setTestDateStr();
        }
        return testRecord;
    }


}
