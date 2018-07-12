package com.chiyi.user.function;

import com.chiyi.user.entity.UserEntity;
import org.springframework.transaction.annotation.Transactional;


public interface UserFunction {
    /**
     * 用户登陆
     * @param account
     * @param password
     * @return
     * @throws Exception
     */
    public UserEntity login(String account, String password)throws Exception;

    @Transactional
    public UserEntity updatePassword(String id, String oldPassword, String newPassword, String newPasswordConfirm)throws Exception;

    @Transactional
    public boolean register(String account, String name, String password, String email)throws Exception;
}
