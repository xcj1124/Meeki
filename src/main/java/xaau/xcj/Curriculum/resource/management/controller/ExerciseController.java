package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xaau.xcj.Curriculum.resource.management.entity.Exercise;
import xaau.xcj.Curriculum.resource.management.entity.Page;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.ExerciseService;
import xaau.xcj.Curriculum.resource.management.unit.GetUrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/15 10:55
 * @message:
 */
@Controller
public class ExerciseController {
    @Autowired
    private ExerciseService exerciseService;
    @RequestMapping("/testExercise.html")
    public String testExercise(Exercise exercise,Model model, HttpSession session, HttpServletRequest request){
        User user=(User)session.getAttribute("user");
        int type=user.getType();
        if(type==0) {
            int num=5;
            List<Exercise> exerciseList=this.exerciseService.limitTest(num);
            model.addAttribute("exerciseList",exerciseList);
            return "studenttestExercise.html";
        }else{
            String cp = request.getParameter("cp");
            // 总记录数
            int sum = this.exerciseService.findSum(exercise);
            // 获得请求URL
            String url = GetUrl.getUrl(request);
            // 创建page对象
            Page<Exercise> listPage = new Page<Exercise>();
            // 创建Admin_consume集合对象
            List<Exercise> adc = null;
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
            adc = this.exerciseService.findEx(exercise,listPage.getNs(),
                    listPage.getPs());
            model.addAttribute("pg", listPage);
            model.addAttribute("exerciseList", adc);
            return "testExercise.html";
        }
    }

//添加试题
    @RequestMapping("/addTest")
    @ResponseBody
    public String addTest(Exercise exercise){
        return this.exerciseService.addTest(exercise);
    }

    //删除试题
    @RequestMapping("/deleteTest")
    @ResponseBody
    public String deleteTest(int id){
        return this.exerciseService.deleteTest(id);
    }

    //修改试题

    //根据id查出信息
    @RequestMapping("/findTest")
    @ResponseBody
    public Exercise findTest(int id){
        return this.exerciseService.findTest(id);
    }
    //修改
    @RequestMapping("/updataTest")
    @ResponseBody
    public String updataTest(Exercise exercise){
        return this.exerciseService.updataTest(exercise);
    }
}
