package ren.ashin.demo.shiro.jdbcrealm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroDemo {
    // 快速生成 psvm
    public static void main(String[] args) {
        // 选中资源文件， ctrl+shift+n快速定位到资源文件
        // SecurityManager ---> factory
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
        // 快速生成变量及对应的类型：ctrl+alt+v
        SecurityManager securityManager = factory.getInstance();

        // 当前用户Subject--->SecurityUtils
        SecurityUtils.setSecurityManager(securityManager);
        // 当前用户
        Subject user = SecurityUtils.getSubject();
        // 通过UsernamePasswordToken来模拟html/jsp传递过来的用户名密码
        UsernamePasswordToken token = new UsernamePasswordToken("bigbird", "123456");
        // 通过shiro来判断用户是否登录成功
        // login 不返回结果，需要通过捕获异常判断是否登录成功
        // 生成try catch 快捷键ctrl+alt+t
        try {
            user.login(token);
            // 快速生成 sout
            System.out.println("登录成功");
        } catch (AuthenticationException e) {
            System.out.println("登录失败");
        }

    }
}
