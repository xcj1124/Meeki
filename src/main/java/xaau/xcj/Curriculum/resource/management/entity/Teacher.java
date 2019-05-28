package xaau.xcj.Curriculum.resource.management.entity;

/**
 * @auther: Meeki
 * @data: 2019/5/6 15:57
 * @message:教师信息实体层
 */
public class Teacher {
    private int id;//教师编号
    private String name; //教师姓名
    private int age; //教师年龄
    private int time; //教龄
    private String phone; //联系电话
    private String msg; //简介
    private String img; //头像

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
