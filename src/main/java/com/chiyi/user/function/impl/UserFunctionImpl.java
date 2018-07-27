package com.chiyi.user.function.impl;

import com.chiyi.common.ThisSystemException;
import com.chiyi.common.ThisSystemUtil;
import com.chiyi.user.dao.UserDao;
import com.chiyi.user.entity.UserEntity;
import com.chiyi.user.function.UserFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.chiyi.common.AssertThrowUtil.*;

@Service
public class UserFunctionImpl implements UserFunction {


    @Autowired
    UserDao userDao;
    @Override
    public UserEntity login(String account, String password) throws Exception {
        account = $("账户不能为空",account);
        password = $("密码不能为空",password);
//        password = ThisSystemUtil.EncoderByMd5(password);
        UserEntity userEntity = (UserEntity) userDao.select("account",account);
        if(userEntity == null){
            throw new ThisSystemException("账户不存在！");
        }
        if(!userEntity.getPassword().equals(password)){
            throw new ThisSystemException("密码错误！");
        }
        return userEntity;
    }

    @Override
    public void register(String account, String name, String password, String email) throws Exception {
        //1 验证用户是否存在
        UserEntity userEntity;
        account = $("账户不能为空",account);
        name = $("名字不能为空",name);
        email = $("邮箱不能为空",email);
        password = $("密码不能为空",password);
        userEntity = (UserEntity) userDao.select("account",account);
        assertNull("账户已存在",userEntity);
        userEntity = (UserEntity) userDao.select("name",name);
        assertNull("姓名已存在",userEntity);
        userEntity = (UserEntity) userDao.select("email",email);
        assertNull("邮箱已存在",userEntity);
        //2 插入用户
        UserEntity newUser = new UserEntity(account,name,password,email);
        userDao.insert(newUser);
    }

    @Override
    public UserEntity updatePassword(String id,String oldPassword, String newPassword, String newPasswordConfirm) throws Exception {
        //1验证参数
        id = $("id不能为空",id);
        oldPassword = $("oldPassword不能为空",oldPassword);
        newPassword = $("newPassword不能为空",newPassword);
        newPasswordConfirm = $("newPasswordConfirm不能为空",newPasswordConfirm);
        assertEquals("两次密码不一致",newPassword,newPasswordConfirm);
        assertNotEquals("新密码和旧密码不能一样",oldPassword,newPassword);

        //2找到用户
        UserEntity userEntity = (UserEntity) userDao.select("id",id);
        assertNotNull("该用户不存在",userEntity);

        //3验证旧密码
        oldPassword = ThisSystemUtil.EncoderByMd5(oldPassword);
        assertEquals("旧密码不正确",userEntity.getPassword(),oldPassword);

        //4更新新密码
        newPassword = ThisSystemUtil.EncoderByMd5(newPassword);
        userEntity.setPassword(newPassword);

        userDao.update(userEntity);
        return userEntity;
    }

}
