package com.xx.webframework.app.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashMap;
import java.util.Map;

public class UserRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(Set.);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        Map<String, Object> map = new HashMap<>(16);
        map.put("username", username);
        String password = new String((char[]) token.getCredentials());

        // 查询用户信息
//        UserDO user = userMapper.list(map).get(0);

        // 账号不存在
//        if (user == null) {
//            throw new UnknownAccountException("账号或密码不正确");
//        }
//
//        // 密码错误
//        if (!password.equals(user.getPassword())) {
//            throw new IncorrectCredentialsException("账号或密码不正确");
//        }
//
//        // 账号锁定
//        if (user.getStatus() == 0) {
//            throw new LockedAccountException("账号已被锁定,请联系管理员");
//        }
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo("user", password, getName());
        return info;
    }

}