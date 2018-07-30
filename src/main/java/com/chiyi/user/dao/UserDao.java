package com.chiyi.user.dao;

import com.chiyi.common.AbstractDao;
import com.chiyi.user.entity.UserEntity;

import java.util.Set;

public interface UserDao extends AbstractDao {

    public UserEntity getByUserAccount(String account);

    public Set<String> getRoles(String account);

    public Set<String> getPermissions(String account);

}
