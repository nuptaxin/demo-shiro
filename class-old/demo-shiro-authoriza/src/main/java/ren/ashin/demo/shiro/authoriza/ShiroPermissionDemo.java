package ren.ashin.demo.shiro.authoriza;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.subject.Subject;
import ren.ashin.demo.shiro.authoriza.utils.ShiroUtil;

import java.util.Arrays;
import java.util.List;

public class ShiroPermissionDemo {
    public static void main(String[] args) {
        Subject user = ShiroUtil.login("classpath:shiro_role_permission.ini", "bigbird", "123");
        boolean permitted = user.isPermitted("InRoom:xiaoFei");
        System.out.println("permitted:"+permitted);
        // 判断某个用户是否具有多个权限
        boolean[] permitted1 = user.isPermitted("InRoom:xiaoFei", "InRoom:update");
        System.out.println("permitted1:"+Arrays.toString(permitted1));
        // 使用check方式判断权限
        try {
            user.checkPermission("InRoom:xiaoFei");
            System.out.println("bigbird有消费记录权限");
        } catch (AuthorizationException e) {
            System.out.println("bigbird没有消费记录权限");
            e.printStackTrace();
        }


    }
}
