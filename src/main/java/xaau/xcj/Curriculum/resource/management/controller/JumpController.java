package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xaau.xcj.Curriculum.resource.management.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @auther: Meeki
 * @data: 2019/3/19 16:20
 * @message:
 */
@Controller
public class JumpController {
    //退出


    //负责跳转到登陆界面
    @RequestMapping("/login.html")
    public String goLogin() {
        return "login";
    }

    //跳转到主界面
    @RequestMapping("/index.html")
    public String goIndex(Model model, HttpSession session) {
        User user=(User)session.getAttribute("user");
        if(user!=null){
            model.addAttribute("loginMsgName",user.getName());
        }
        else {
            model.addAttribute("loginMsgName", "请登录");
        }
            return "index";
    }

    //跳转到注册页面
    @RequestMapping("/register.html")
    public String register() {
        return "register";
    }
}
