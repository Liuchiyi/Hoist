package com.chiyi.user.dao;

import com.chiyi.common.AbstractDao;
import com.chiyi.user.entity.TestRecordEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TestRecordDao extends AbstractDao{
     public TestRecordEntity selectBySth(@Param("key") String ukfield, @Param("value") Object value) throws Exception;
     public List<TestRecordEntity> selectAll() throws Exception;
}
