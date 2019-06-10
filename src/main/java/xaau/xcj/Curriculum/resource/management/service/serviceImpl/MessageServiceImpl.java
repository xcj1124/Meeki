package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.Message;
import xaau.xcj.Curriculum.resource.management.mapper.MessageMapper;
import xaau.xcj.Curriculum.resource.management.service.MessageService;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/21 15:56
 * @message:
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public int totalMsg(Message message) {
        return this.messageMapper.totalMsg(message);
    }

    @Override
    public List<Message> findMessage(Message message, int ns, int ps) {
        return this.messageMapper.findMessage(message, ns, ps);
    }

    @Override
    public int addMessage(Message message) {
        return this.messageMapper.addMessage(message);
    }

    @Override
    public Message findMes(int id) {
        return this.messageMapper.findMes(id);
    }

    @Override
    public int updateMes(Message message) {
        return this.messageMapper.updateMes(message);
    }

    @Override
    public String deleteMsg(int id) {
        int row=this.messageMapper.deleteMsg(id);
        if(row>0){
            return "ok";
        }else {
            return "no";
        }
    }
}
