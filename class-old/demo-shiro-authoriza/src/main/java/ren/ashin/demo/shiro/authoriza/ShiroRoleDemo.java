package ren.ashin.demo.shiro.authoriza;

import org.apache.shiro.subject.Subject;
import ren.ashin.demo.shiro.authoriza.utils.ShiroUtil;

import java.util.Arrays;
import java.util.List;

public class ShiroRoleDemo {
    public static void main(String[] args) {
        Subject user = ShiroUtil.login("classpath:shiro_role_permission.ini", "superbird", "123456");
        boolean flag1 = user.hasRole("system");
        System.out.println("flag1:"+flag1);

        Subject user1 = ShiroUtil.login("classpath:shiro_role_permission.ini", "bigbird", "123");
        List<String> roleList = Arrays.asList("role1", "role2", "system");
        boolean[] flag2 = user1.hasRoles(roleList);
        System.out.println(Arrays.toString(flag2));

    }
}
