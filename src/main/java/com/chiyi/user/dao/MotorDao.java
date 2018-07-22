package com.chiyi.user.dao;

import com.chiyi.common.AbstractDao;
import com.chiyi.user.entity.MotorEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MotorDao extends AbstractDao{
     public MotorEntity selectBySth (@Param("key") String ukfield, @Param("value") Object value) throws Exception;
     public List<MotorEntity> selectAll() throws Exception;
}
