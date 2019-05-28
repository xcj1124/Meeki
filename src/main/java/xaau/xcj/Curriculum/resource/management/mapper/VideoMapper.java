package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xaau.xcj.Curriculum.resource.management.entity.CoureseMsg;

/**
 * @auther: Meeki
 * @data: 2019/4/18 15:17
 * @message:
 */
public interface VideoMapper {
    //添加视频
    @Insert("INSERT INTO coursemsg(NAME,url) VALUE(#{coureseMsg.name},#{coureseMsg.url})")
    public int addVideo(@Param("coureseMsg")CoureseMsg coureseMsg);
    //删除视频
    @Delete("DELETE from coursemsg where id=#{id}")
    public int deleteVideo( @Param("id")int id);
    //根据id查询视频信息
    @Select("select * from coursemsg where id=#{id}")
    public CoureseMsg findTpId(@Param("id") int id);
    //修改视频
    public int updateVid(@Param("cou") CoureseMsg coureseMsg);

}

