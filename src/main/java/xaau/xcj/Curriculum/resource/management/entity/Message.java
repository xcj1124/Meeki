package xaau.xcj.Curriculum.resource.management.entity;

/**
 * @auther: Meeki
 * @data: 2019/5/15 22:46
 * @message:课程信息
 */
public class Message {
    private int id;  //课程编号
    private String name; //课程名
    private String teaName; //讲师姓名
    private String time; //开课时间
    private String msg; //内容简介
    private String zhangjie; //章节
    private String img; //封面

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
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

    public String getZhangjie() {
        return zhangjie;
    }

    public void setZhangjie(String zhangjie) {
        this.zhangjie = zhangjie;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
