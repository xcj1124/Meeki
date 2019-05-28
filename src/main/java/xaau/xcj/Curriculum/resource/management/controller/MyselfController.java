package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xaau.xcj.Curriculum.resource.management.entity.User;

import javax.servlet.http.HttpSession;

/**
 * @auther: Meeki
 * @data: 2019/5/21 20:08
 * @message:跳转到个人信息
 */
@Controller
public class MyselfController {
    @RequestMapping("myself.html")
    public String goMyself(HttpSession session, Model model){
        User user= (User)session.getAttribute("user");
        model.addAttribute("user",user);
        return "myself.html";
    }
}
