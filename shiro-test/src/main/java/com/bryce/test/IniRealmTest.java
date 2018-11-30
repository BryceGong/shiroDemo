package com.bryce.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;


public class IniRealmTest {

    @Test
    public  void testAuthentication() {
        IniRealm iniRealm = new IniRealm("classpath:user.ini");

        // 1 构建securityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(iniRealm);
        // 2 subject提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("bryce", "123456");

        subject.login(usernamePasswordToken);

        System.out.println("isAuthenticated:" + subject.isAuthenticated());

        /*subject.logout();
        System.out.println("isAuthenticated:" + subject.isAuthenticated());*/

        subject.checkRoles("admin");

        subject.checkPermission("user:delete");
    }
}
