package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xaau.xcj.Curriculum.resource.management.entity.Message;
import xaau.xcj.Curriculum.resource.management.entity.Page;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.MessageService;
import xaau.xcj.Curriculum.resource.management.unit.FileUtils;
import xaau.xcj.Curriculum.resource.management.unit.GetUrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @auther: Meeki
 * @data: 2019/3/21 15:50
 * @message:
 */
@Controller
public class CoureseController {
    @Autowired
    private MessageService messageService;

    //跳转到课程简介
    @RequestMapping("/coureseMsg.html")
    public String coureseMsg(Message message, HttpServletRequest request, Model model, HttpSession session) {
        String cp = request.getParameter("cp");//获取请求参数
        String url = GetUrl.getUrl(request); //获取请求url
        int ts = this.messageService.totalMsg(message);//获取总数
        Page<Message> page = new Page<>();//创建page对象用来存放分页信息
        List<Message> list = null; //创建list对象存放当前页的数据
        page.setPs(1); //设置每页存放的个数
        page.setTs(ts); //设置总记录数
        page.setUrl(url); //设置url
        if (null == cp || cp == "") {
            page.setCp(1);
        } else {
            page.setCp(Integer.parseInt(cp));
        }
        list = this.messageService.findMessage(message, page.getNs(), page.getPs());
        page.setList(list);
        model.addAttribute("msg", list);
        model.addAttribute("pg", page);
        User user = (User) session.getAttribute("user");
        int type = user.getType();
        if (type == 0) {
            return "studentcoureseMsg.html";
        } else {
            return "coureseMsg.html";
        }
    }

    @RequestMapping("/addMsg")
    @ResponseBody
    public String imageUpload(Message message) {
        message.setImg("/static/image/3.jpg ");
        int row=this.messageService.addMessage(message);
        if(row>0){
            return "ok";
        }else{
            return "no";
        }
    }

    @RequestMapping("/findMes")
    @ResponseBody
    public Message findMes(int id){
        return this.messageService.findMes(id);
    }

    @RequestMapping("/updateMes")
    @ResponseBody
    public String updateMes(Message message){
        int row=this.messageService.updateMes(message);
        if(row>0){
            return "ok";
        }else{
            return "no";
        }
    }

    @RequestMapping("/deleteMsg")
    @ResponseBody
    public String deleteMsg(int id){
        return this.messageService.deleteMsg(id);
    }

}
