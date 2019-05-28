package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xaau.xcj.Curriculum.resource.management.entity.User;

public interface UserMapper {
    @Select("select * from user where id =#{id}")
    public User findUserById(@Param("id") Integer id);

    @Insert("INSERT INTO USER(id,PASSWORD,NAME) VALUE(#{user.id},#{user.password},#{user.name})")
    public int addUser(@Param("user") User user);

    public int updataUser(@Param("id") String id,@Param("user") User user);

    public int updateImage(@Param("imgUrl")String imgUrl, @Param("id")String id);
    @Select("SELECT password from `user` where id=#{id} ")
    public String findUserPwd(@Param("id") String id); //根据id查看密码旧密码是否正确
    @Update("update `user` set password=#{pwd} where id=#{id}")
    public int updatePwd(@Param("pwd") String pwd,String id); //修改密码
}
