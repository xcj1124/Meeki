package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xaau.xcj.Curriculum.resource.management.entity.User;

/**
 * @auther: Meeki
 * @data: 2019/3/20 11:43
 * @message:注册映射层
 */
public interface RegisterMapper {
    //检车用户是否存在
    @Select("SELECT * FROM USER WHERE id=#{id}")
    public User checkUser(@Param("id") String id);

    //注册
    @Insert("INSERT INTO USER(id,PASSWORD,NAME,PHONO,IMG,TYPE) VALUE(#{user.id},#{user.password},#{user.name},#{user.phono},#{user.img},#{user.type})")
    public int regUser(@Param("user") User user);
}
