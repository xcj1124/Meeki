package xaau.xcj.Curriculum.resource.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xaau.xcj.Curriculum.resource.management.entity.Board;
import xaau.xcj.Curriculum.resource.management.entity.Page;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.service.BoardService;
import xaau.xcj.Curriculum.resource.management.unit.GetUrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/8 18:06
 * @message:
 */
@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;

    // 查看所有的留言
    @RequestMapping("/board.html")
    public String allConsume(Model model, HttpServletRequest request) {
        // 获取请求的参数pc
        String cp = request.getParameter("cp");
        // 总记录数
        int sum = this.boardService.allConsumeNum();
        // 获得请求URL
        String url = GetUrl.getUrl(request);
        // 创建page对象
        Page<Board> listPage = new Page<Board>();
        // 创建Admin_consume集合对象
        List<Board> adc = null;
        // 赋值总记录数
        listPage.setTs(sum);
        // 设置url
        listPage.setUrl(url);
        // 设置每页显示的条数
        listPage.setPs(2);
        if (cp == null || cp.trim().isEmpty()) {
            listPage.setCp(1);
        } else {
            listPage.setCp(Integer.parseInt(cp));
        }
        adc = this.boardService.findConsumeToNum(listPage.getNs(),
                listPage.getPs());
        listPage.setList(adc);
        model.addAttribute("lp", listPage);
        model.addAttribute("adc", adc);

        return "board.html";
    }

    // 添加留言
    @RequestMapping("/addAdminConsume")
    @ResponseBody
    public
    String addAdminConsume(String consumeMsg, HttpSession session) {
        // 获取当前登录用户id
        String id = ((User) session.getAttribute("user"))
                .getId();
        Board board = new Board(); // 留言内容
        // 时间
        System.out.println("----------------->"+id);
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH) + 1;
        int minu = calendar.get(Calendar.MINUTE);
        String minute = String.valueOf(calendar.get(Calendar.MINUTE));
        if (minu < 10) {
            minute = "0" + minute;
        }
        String nowtime = calendar.get(Calendar.YEAR) + "-" + month + "-"
                + calendar.get(Calendar.DATE) + " "
                + calendar.get(Calendar.HOUR_OF_DAY) + ":" + minute;
        board.setUser_Id(id);
        board.setConsumeMsg(consumeMsg);
        board.setNewtime(nowtime);
        int row = this.boardService.addConsume(board);
        if (row > 0) {
            return "ok";
        } else {
            return "no";
        }
    }

}
