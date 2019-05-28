package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xaau.xcj.Curriculum.resource.management.entity.Page;
import xaau.xcj.Curriculum.resource.management.entity.Teacher;
import xaau.xcj.Curriculum.resource.management.service.TeacherTeaService;
import xaau.xcj.Curriculum.resource.management.unit.GetUrl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/8 16:23
 * @message:
 */
@Controller
public class TeacherController {
    @Autowired
    private TeacherTeaService teacherTeaService;
    @RequestMapping("/teacherTeam.html")
    public String teacherTea(Teacher teacher,HttpServletRequest request, Model model){
        // 获取请求参数
        String cp = request.getParameter("cp");
        // 获取请求URL
        String url = GetUrl.getUrl(request);
        // 获取总记录数
        int ts = this.teacherTeaService.totalTea(teacher);
        // 创建page对象
        Page<Teacher> page = new Page<>();
        // 创建list对象获得当前页面保存的记录
        List<Teacher> list = null;
        // 设置每页显示的个数
        page.setPs(4);
        // 设置总记录数
        page.setTs(ts);
        // 设置URL
        page.setUrl(url);
        if (cp == null || cp == "") {
            page.setCp(1);
        } else {
            page.setCp(Integer.parseInt(cp));
        }
        list = this.teacherTeaService.limitTea(teacher,page.getNs(), page.getPs());
        page.setList(list);
        model.addAttribute("vg", list);
        model.addAttribute("pg", page);
        return "teacherTeam.html";
    }
}
