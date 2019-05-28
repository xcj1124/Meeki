package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.Message;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/21 15:53
 * @message:课程信息服务层
 */
public interface MessageService {
    public int totalMsg(Message message);
    public List<Message> findMessage(Message message, int ns,int ps );
    public int addMessage(Message message);  //添加课程
    public Message findMes(int id);
    public int updateMes(Message message);
}
