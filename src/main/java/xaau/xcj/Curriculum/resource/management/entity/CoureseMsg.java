package xaau.xcj.Curriculum.resource.management.entity;

/**
 * @auther: Meeki
 * @data: 2019/3/21 15:27
 * @message:视频
 */
public class CoureseMsg {
    private Integer id;  //编号
    private Integer num;
    private String name; //名字
    private String cover;//封面
    private String message;//课程的简介
    private String url;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
