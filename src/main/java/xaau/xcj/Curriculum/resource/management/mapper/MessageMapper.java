package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import xaau.xcj.Curriculum.resource.management.entity.Message;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/21 15:47
 * @message:
 */
public interface MessageMapper {
    public int totalMsg(@Param("message")Message message);
    public List<Message> findMessage(@Param("message")Message message,@Param("ns") int ns, @Param("ps") int ps );
    @Insert("insert INTO message(name,teaName,time,msg,zhangjie,img) VALUES(#{message.name},#{message.teaName},#{message.time},#{message.msg},#{message.zhangjie},#{message.img})")
    public int addMessage(@Param("message")Message message);

    public Message findMes(@Param("id") int id);
    public int updateMes(@Param("ms")Message message);
}
