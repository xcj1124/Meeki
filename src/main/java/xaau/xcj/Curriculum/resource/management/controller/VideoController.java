package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xaau.xcj.Curriculum.resource.management.entity.CoureseMsg;
import xaau.xcj.Curriculum.resource.management.entity.Page;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.CourseService;
import xaau.xcj.Curriculum.resource.management.service.VideoService;
import xaau.xcj.Curriculum.resource.management.unit.GetUrl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @auther: Meeki
 * @data: 2019/4/10 15:00
 * @message:
 */
@Controller
public class VideoController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private VideoService videoService;
    //跳转到视频
    @RequestMapping("/video.html")
    public String coureseMsg(CoureseMsg coureseMsg,HttpServletRequest request, Model model, HttpSession session) {
        User user=(User)session.getAttribute("user");
        int type=user.getType();
        // 获取请求参数
        String cp = request.getParameter("cp");
        // 获取请求URL
        String url = GetUrl.getUrl(request);
        // 获取总记录数
        int ts = this.courseService.findSum(coureseMsg);
        // 创建page对象
        Page<CoureseMsg> page = new Page<>();
        // 创建list对象获得当前页面保存的记录
        List<CoureseMsg> list = null;
        // 设置每页显示的个数
        page.setPs(8);
        // 设置总记录数
        page.setTs(ts);
        // 设置URL
        page.setUrl(url);
        if (cp == null || cp == "") {
            page.setCp(1);
        } else {
            page.setCp(Integer.parseInt(cp));
        }
        list = this.courseService.findCourse(coureseMsg,page.getNs(), page.getPs());
        page.setList(list);
        model.addAttribute("vg", list);
        model.addAttribute("pg", page);
        if(type==0) {
            return "studentVideo.html";
        }else{
            return "video.html";
        }
    }

    @RequestMapping("/addVid")
    @ResponseBody
    public String addVideo(HttpServletRequest request,CoureseMsg coureseMsg,
                           @RequestParam(value = "url", required = false) MultipartFile filename){
        // 使用UUID重命名，并去掉四个“-”
        String name = UUID.randomUUID().toString().replaceAll("-", "");
       // String ext = FilenameUtils.getExtension(filename.getOriginalFilename());
        // 设置上传路径
        String url = request.getSession().getServletContext()
                .getRealPath("/image");
        // 以绝对路径保存重名命后的视频

        int rows=this.videoService.addVideo(coureseMsg);
        if(rows>0){
            return "ok";
        }else {
            return "no";
        }
    }

    @RequestMapping("/deleteVideo")
    @ResponseBody
    public String deleteVideo(int id){
        int rows=this.videoService.deleteVideo(id);
        if(rows>0){
            return "ok";
        }else{
            return "no";
        }
    }

    @RequestMapping("/findVid")
    @ResponseBody
    public CoureseMsg findVid(int id){
        CoureseMsg cm=this.videoService.findTpId(id);
        return cm;
    }

    @RequestMapping("/updateVid")
    @ResponseBody
    public String updateVid(int id,CoureseMsg coureseMsg){
        int row=this.videoService.updateVid(coureseMsg);
        if(row>0){
            return "ok";
        }else{
            return "no";
        }
    }
}
