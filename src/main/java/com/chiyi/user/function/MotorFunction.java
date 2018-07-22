package com.chiyi.user.function;

import com.chiyi.user.entity.MotorEntity;

import java.util.List;


public interface MotorFunction {

    public List<MotorEntity> motorSearch() throws Exception;
    public MotorEntity motorSearchById(String motorId) throws Exception;


}
