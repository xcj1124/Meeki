package xaau.xcj.Curriculum.resource.management.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @auther: Meeki
 * @data: 2019/3/12 16:20
 * @message:用户控制层
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    public String getFind(){
        return "login";
    }
    @RequestMapping(value = "/findUser")
    public String findUser(Model model,Integer id) {
        User user=this.userService.findUserById(id);
        model.addAttribute("user",user);
        return "success";
    }

    @RequestMapping("/updateMyselef")
    @ResponseBody
    public String updateMyselef(User user,String id,HttpSession session){
        User user1=(User)session.getAttribute("user");
        if(null!=user.getName()){
            user1.setName(user.getName());
        }if(null!=user.getPhono()){
            user1.setPhono(user.getPhono());
        }
        id=user1.getId();
        int row=this.userService.updataUser(id, user);
        if(row>0){
            return  "ok";
        }else{
            return "no";
        }
    }


    // 修改头像
    @RequestMapping(value = "/updateImage",method =RequestMethod.POST)
    public @ResponseBody
    String updateImage(HttpServletRequest request,@RequestParam(value = "filename", required = false) MultipartFile filename, HttpSession session, String id) throws Exception, IOException {
        System.out.println("updateImage");
        id = ((User) session.getAttribute("user")).getId();
        // 使用UUID给图片重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取文件的扩展名
        String ext = FilenameUtils.getExtension(filename.getOriginalFilename());
        // 设置图片上传路径
        String url = request.getSession().getServletContext()
                .getRealPath("/image");
        // 以绝对路径保存重名命后的图片
        filename.transferTo(new File(url + "/" + name + "." + ext));
        String imgurl = "image/" + name + "." + ext;
        int row = this.userService.updateImage(imgurl, id);
        if (row > 0) {
            ((User) session.getAttribute("user")).setPhono(imgurl);
            return "ok";
        } else {
            return "no";
        }
    }

    @RequestMapping("/findUserPwd")
    @ResponseBody
    public String findUserPwd(String pwd,HttpSession session) { //根据id查看旧密码是否正确
        String id=((User) session.getAttribute("user")).getId();
        return this.userService.findUserPwd(id,pwd);
    }

    @RequestMapping("/updatePwd")
    @ResponseBody
    public String updatePwd(String newPwd,HttpSession session) { //修改密码
        String id=((User) session.getAttribute("user")).getId();
        return this.userService.updatePwd(newPwd, id);
    }
}
