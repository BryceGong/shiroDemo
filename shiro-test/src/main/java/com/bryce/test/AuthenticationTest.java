package com.bryce.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;


/**
 * idea 快速查找实现类         ctrl + alt +B
 *
 * 使用authenticator做认证
 * authenticator 找到realm去做认证
 *
 *
 *  subject.login() -->  this.securityManager.login(this, token)  --> this.authenticate(token) --> this.authenticator.authenticate(token) --
 *  -->this.doAuthenticate(token) --> doAuthenticate(AuthenticationToken authenticationToken) 找到realm 对比认证数据
 */
public class AuthenticationTest {
    SimpleAccountRealm simpleAccountRealm = new SimpleAccountRealm();

    @Before
    public  void addUser(){
        simpleAccountRealm.addAccount("bryce","123456","admin","user");
    }

    @Test
    public  void testAuthentication() {
        // 1 构建securityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(simpleAccountRealm);

        // 2 subject提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("bryce", "123456");

        subject.login(usernamePasswordToken);

        System.out.println("isAuthenticated:" + subject.isAuthenticated());

        /*subject.logout();
        System.out.println("isAuthenticated:" + subject.isAuthenticated());*/

        subject.checkRoles("admin","user");
    }
}
