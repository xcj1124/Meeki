package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.RegService;

/**
 * @auther: Meeki
 * @data: 2019/3/20 11:32
 * @message:用户注册控制层
 */
@RestController
public class ResgisterController {
    @Autowired
    private RegService regService;
    //检查id是否已经存在
    @RequestMapping(value = "/checkId")
    public String checkUser(String id) throws Exception{
        User user=null;
        user=this.regService.checkUser(id);
        if (user == null) {
            return "ok";
        } else {
            return "no";
        }
    }
    //用户注册
    @RequestMapping("/regUser")
    public String regUser(User user) {
        user.setImg("/static/image/1.png");
        user.setType(0);
        int row = this.regService.regUser(user);
        if (row > 0) {
            return "ok";
        } else {
            return "no";
        }
    }
}
