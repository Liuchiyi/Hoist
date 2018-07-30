package com.realm;


import com.chiyi.user.entity.UserEntity;
import com.chiyi.user.function.UserFunction;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

public class MyRealm extends AuthorizingRealm {
    @Resource
    private UserFunction userFunctionImpl;

    //为当前登录成功的用户授予权限和角色，已经登录成功了。
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String account=(String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo=new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userFunctionImpl.getRoles(account));
        authorizationInfo.setStringPermissions(userFunctionImpl.getPermissions(account));
        return authorizationInfo;
    }
    //验证当前登录的用户，获取认证信息。
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String account=(String) token.getPrincipal();//获取账号
        UserEntity user=userFunctionImpl.getByUserAccount(account);
        if(user!=null){
            AuthenticationInfo authcInfo =new SimpleAuthenticationInfo(user.getAccount(),user.getPassword(),"myRealm");
            return authcInfo;
        }else{
            return null;
        }
    }

    public static void main(String[] args){


	/*	//md5加密
		String hashAlgorithmName = "MD5";
        String credentials = "admin";
        int hashIterations = 1024;
        Object obj = new SimpleHash(hashAlgorithmName, credentials, null, hashIterations);
        System.out.println(obj);*/


        String hashAlgorithmName = "MD5";
        String credentials = "admin";
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes("admin");
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);

    }
}