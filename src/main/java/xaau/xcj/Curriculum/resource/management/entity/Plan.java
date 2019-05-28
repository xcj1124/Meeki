package xaau.xcj.Curriculum.resource.management.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @auther: Meeki
 * @data: 2019/5/13 15:40
 * @message:
 */
public class Plan {
    private int id;
    private String name;
    private String teaName;
    private String time;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
