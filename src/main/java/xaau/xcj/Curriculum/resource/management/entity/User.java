package xaau.xcj.Curriculum.resource.management.entity;

/**
 * @auther: Meeki
 * @data: 2019/3/12 15:38
 * @message:用户实体类 包含了用户的信息
 */
public class User {
    private String id;   //账号
    private String password;  //密码
    private String name;  //用户姓名
    private String phono; //头像
    private String img; //电话
    private int type; //用户类型

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getId() {
        return id;
    }

    public String getPhono() {
        return phono;
    }

    public void setPhono(String phono) {
        this.phono = phono;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
