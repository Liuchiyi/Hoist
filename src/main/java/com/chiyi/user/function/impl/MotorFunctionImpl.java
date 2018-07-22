package com.chiyi.user.function.impl;

import com.chiyi.common.ThisSystemException;
import com.chiyi.common.ThisSystemUtil;
import com.chiyi.user.dao.MotorDao;
import com.chiyi.user.dao.UserDao;
import com.chiyi.user.entity.MotorEntity;
import com.chiyi.user.entity.UserEntity;
import com.chiyi.user.function.MotorFunction;
import com.chiyi.user.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.chiyi.common.AssertThrowUtil.*;

@Service
public class MotorFunctionImpl implements MotorFunction {


    @Autowired
    MotorDao motorDao;



    @Override
    public List<MotorEntity> motorSearch() throws Exception {

        List<MotorEntity> motorList =  motorDao.selectAll();
        if(motorList == null){
            throw new ThisSystemException("无记录！！！");
        }
        return motorList;
    }

    @Override
    public MotorEntity motorSearchById(String motorId) throws Exception {
        MotorEntity motor = (MotorEntity)motorDao.selectBySth("id",motorId);
        if(motor == null){
            throw new ThisSystemException("该种电动葫芦不存在");
        }
        return motor;
    }
}
