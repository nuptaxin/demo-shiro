package ren.ashin.demo.shiro.shiro2.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LogonAction {
    @RequestMapping("logon")
    public String logon(@RequestParam String username, @RequestParam String password){
        if(username.equals("tom")&&password.equals("123")){
            return "success";
        }
        return "abc";
    }
}
