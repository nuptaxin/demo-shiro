package ren.ashin.demo.shiro.authoriza.utils;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {
    public static Subject login(String configPath, String username, String password){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configPath);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            user.login(token);
            System.out.println(username+", 登录成功");
        } catch (AuthenticationException e) {
            System.out.println(username+", 登录失败");
        }
        return user;
    }
}
