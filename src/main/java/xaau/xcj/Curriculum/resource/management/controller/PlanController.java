package xaau.xcj.Curriculum.resource.management.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xaau.xcj.Curriculum.resource.management.entity.Page;
import xaau.xcj.Curriculum.resource.management.entity.Plan;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.PlanService;
import xaau.xcj.Curriculum.resource.management.unit.FileUtil;
import xaau.xcj.Curriculum.resource.management.unit.GetUrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @auther: Meeki
 * @data: 2019/5/13 16:29
 * @message:
 */
@Controller
public class PlanController {
    @Autowired
    private PlanService planService;
    // 跳转到课程教案
    @RequestMapping("/coursePlan.html")
    public String coursePlan(Plan plan,Model model, HttpServletRequest request, HttpSession session){
        User user=(User)session.getAttribute("user");
        int type=user.getType();
        // 获取请求的参数pc
        String cp = request.getParameter("cp");
        // 总记录数
        int sum = this.planService.sumPlan(plan);
        // 获得请求URL
        String url = GetUrl.getUrl(request);
        // 创建page对象
        Page<Plan> listPage = new Page<Plan>();
        // 创建Admin_consume集合对象
        List<Plan> adc = null;
        // 赋值总记录数
        listPage.setTs(sum);
        // 设置url
        listPage.setUrl(url);
        // 设置每页显示的条数
        listPage.setPs(5);
        if (cp == null || cp.trim().isEmpty()) {
            listPage.setCp(1);
        } else {
            listPage.setCp(Integer.parseInt(cp));
        }
        adc = this.planService.findPlan(plan,listPage.getNs(),
                listPage.getPs());

        model.addAttribute("lp", listPage);
        model.addAttribute("adc", adc);
        if(type==0) {
            return "studentcoursePlan.html";
        }else{
            return "coursePlan.html";
        }
    }



    @RequestMapping("/deletePlan")
    @ResponseBody
    public String deletePlan(int id){
        int rows=this.planService.deletePlan(id);
        if(rows>0){
            return "ok";
        }else{
            return "no";
        }
    }

    @RequestMapping("/addPlan")
    @ResponseBody
    public String addPlan( @RequestParam("file") MultipartFile file,Plan plan,HttpServletRequest request) throws IOException {
        Date date=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD HH:mm:ss");
        String time=sdf.format(date);
        plan.setTime(time);
        String name = UUID.randomUUID().toString().replaceAll("-", "");
        // 获取文件的扩展名
        String ext = FilenameUtils.getExtension(file.getOriginalFilename());
        // 设置图片上传路径
        String url = request.getSession().getServletContext()
                .getRealPath("/word");
        // 以绝对路径保存重名命后的图片
        file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\Curriculum resource management\\src\\main\\resources\\static\\word" + "/" + name + "." + ext));
        String imgurl = "static/word/" + name + "." + ext;
        plan.setMsg(imgurl);
        int rows=this.planService.addPlan(plan);
        if(rows>0){
            return "coursePlan.html";
        }else{
            return "no";  //
        }
    }
    @RequestMapping("/findP")
    @ResponseBody
    public Plan findP(int id){
        return this.planService.findP(id);
    }
    @RequestMapping("/updatePlan")
    @ResponseBody
    public String updatePlan(Plan plan){
        int rows=this.planService.updatePlan(plan);
        if(rows>0){
            return "ok";
        }else{
            return "no";
        }
    }
}
