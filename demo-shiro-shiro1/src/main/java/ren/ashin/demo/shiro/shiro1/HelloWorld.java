package ren.ashin.demo.shiro.shiro1;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
    private static final Logger LOG = LoggerFactory.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        LOG.info("我们正在测试Log4j...");
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("name", "zxren ");
        String name = (String) session.getAttribute("name");
        if (name != null) {
            LOG.info("shiro名字：" + name);
        }
        if(!subject.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("root", "secret");
            token.setRememberMe(true);
            try {
                subject.login(token);
                LOG.info("登录成功");
            } catch (AuthenticationException e) {
                LOG.error("登录失败", e);
            }
        }

        if(subject.hasRole("admin")){
            LOG.info("拥有指定的角色");
        }else{
            LOG.warn("不拥有指定的角色");
        }

        if(subject.isPermitted("admin111")){
            LOG.info("拥有指定的权限");
        }else{
            LOG.warn("不拥有指定的权限");
        }

        subject.logout();
        System.exit(0);
    }
}
