package xaau.xcj.Curriculum.resource.management.entity;

/**
 * @auther: Meeki
 * @data: 2019/5/8 17:40
 * @message:
 */

public class Board {
        // 管理员的留言
        private int id;
        // 管理员的id
        private String User_Id;
        // 留言内容
        private String consumeMsg;
        // 留言时间
        private String newtime;

        private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUser_Id() {
            return User_Id;
        }

        public void setUser_Id(String user_Id) {
            User_Id = user_Id;
        }

        public String getConsumeMsg() {
            return consumeMsg;
        }

        public void setConsumeMsg(String consumeMsg) {
            this.consumeMsg = consumeMsg;
        }

        public String getNewtime() {
            return newtime;
        }

        public void setNewtime(String newtime) {
            this.newtime = newtime;
        }


}
