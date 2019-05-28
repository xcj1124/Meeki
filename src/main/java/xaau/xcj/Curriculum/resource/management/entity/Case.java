package xaau.xcj.Curriculum.resource.management.entity;

/**
 * @auther: Meeki
 * @data: 2019/4/23 14:17
 * @message:案例实体层
 */
public class Case {
    private int id;  //题号
    private String topic;  //题目
    private String optionA; //选项A
    private String optionB; //选项B
    private String optionC; //选项C
    private String optionD; //选项D
    private String correctAnser; //正确答案

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectAnser() {
        return correctAnser;
    }

    public void setCorrectAnser(String correctAnser) {
        this.correctAnser = correctAnser;
    }
}
