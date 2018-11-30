package com.bryce.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class JdbcRealmTest {
    DruidDataSource druidDataSource = new DruidDataSource();
    {
        druidDataSource.setUrl("jdbc:mysql://120.79.52.156:3306/test");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
    }
    @Test
    public  void testAuthentication() {
        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(druidDataSource);

        //打开权限开关
        jdbcRealm.setPermissionsLookupEnabled(true);
        // 1 构建securityManager 环境
        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
        defaultSecurityManager.setRealm(jdbcRealm);

        // 2 subject提交认证请求
        SecurityUtils.setSecurityManager(defaultSecurityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("bryce", "123456");

        subject.login(usernamePasswordToken);

        System.out.println("isAuthenticated:" + subject.isAuthenticated());


        /*subject.logout();
        System.out.println("isAuthenticated:" + subject.isAuthenticated());*/
        subject.checkRole("admin");
        subject.checkRole("user");
        subject.checkPermission("user:select");
        subject.checkPermission("user:delete");
    }
}
