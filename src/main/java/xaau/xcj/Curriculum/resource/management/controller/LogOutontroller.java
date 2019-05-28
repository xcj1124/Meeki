package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @auther: Meeki
 * @data: 2019/3/20 11:20
 * @message:
 */
@Controller
public class LogOutontroller {
    @RequestMapping(value = "/logOut",method = RequestMethod.GET)
    public String logOut(HttpServletRequest request, HttpSession session){
        session.invalidate();
        request.setAttribute("msg","请重新登陆！");
        return "login";
    }
}
