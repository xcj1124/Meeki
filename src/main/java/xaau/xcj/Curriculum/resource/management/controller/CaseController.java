package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xaau.xcj.Curriculum.resource.management.entity.Case;
import xaau.xcj.Curriculum.resource.management.entity.Page;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.CaseService;
import xaau.xcj.Curriculum.resource.management.unit.GetUrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/4/23 15:53
 * @message:
 */
@Controller
public class CaseController {
    @Autowired
    private CaseService caseService;
    @RequestMapping("/case.html")
    public String coureseCase(Case cases,HttpServletRequest request, Model model, HttpSession session){
        String cp=request.getParameter("cp");//获取请求参数
        String url= GetUrl.getUrl(request); //获取请求url
        int ts=this.caseService.caseSum(cases);//获取总数
        Page<Case> page=new Page<>();//创建page对象用来存放分页信息
        List<Case> list=null; //创建list对象存放当前页的数据
        page.setPs(5); //设置每页存放的个数
        page.setTs(ts); //设置总记录数
        page.setUrl(url); //设置url
        if(null==cp || cp==""){
            page.setCp(1);
        }else{
            page.setCp(Integer.parseInt(cp));
        }
        list=this.caseService.findCase(cases,page.getNs(),page.getPs());
        page.setList(list);
        model.addAttribute("cose", list);
        model.addAttribute("pg", page);
        User user=(User)session.getAttribute("user");
        int type=user.getType();
        if(type==0) {
            return "studentCase.html";
        }else{
            return "case";
        }

    }

    @RequestMapping("/addCase")
    @ResponseBody
    public String addCase(Case aCase){ //添加案例
        int row=this.caseService.addCase(aCase);
        if(row>0){
            return "ok";
        }else{
            return "no";
        }
    }


    @RequestMapping("/deleteCase")
    @ResponseBody
    public String deleteCase(int id){  //刪除案例
        return this.caseService.deleteCase(id);
    }


    @RequestMapping("/findCaseToId")
    @ResponseBody
    public Case findCaseToId(int id){  //根据id查找
        Case aCase=this.caseService.findCaseToId(id);
        return aCase;
    }

    @RequestMapping("/updateCase")
    @ResponseBody
    public String updateCase(Case aCase){  //修改
        int row=this.caseService.updateCase(aCase);
        if(row>0){
            return "ok";
        }else{
            return "no";
        }
    }
}
