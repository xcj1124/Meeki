package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xaau.xcj.Curriculum.resource.management.entity.CoureseMsg;


import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/3/21 15:35
 * @message:课程信息的dao层接口
 */
public interface CourseMapper {
    //查询总记录数
    public int findSum(@Param("cm")CoureseMsg coureseMsg);

    //分页查询
    public List<CoureseMsg> findCourse(@Param("cm")CoureseMsg coureseMsg,@Param("ns") int ns, @Param("ps") int ps);
}
