package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.LoginService;

import javax.servlet.http.HttpSession;

/**
 * @auther: Meeki
 * @data: 2019/3/19 9:16
 * @message:登陆模块控制层
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;

    //负责登陆验证
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String login(User user, HttpSession session) {
        User user1 = this.loginService.login(user);
        if (user1 != null) {
            if(user1.getType()==1) {
                session.setAttribute("type","教师");
            }else{
                session.setAttribute("type","学生");
            }
                session.setAttribute("user", user1);
                return "ok";
            }
         else {
            return "no";
        }

    }
}
