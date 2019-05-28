package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Select;
import xaau.xcj.Curriculum.resource.management.entity.User;

/**
 * @auther: Meeki
 * @data: 2019/3/19 9:00
 * @message: 登陆验证映射层
 */
public interface LoginMapper {
    //验证用户登陆
    @Select("select * from user where id =#{id} and PASSWORD=#{password}")
    public User login(User user);
}
