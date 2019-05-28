package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xaau.xcj.Curriculum.resource.management.entity.Teacher;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/6 18:06
 * @message:教师团队
 */
public interface TeacherMapper {
    public int totalTea(@Param("teacher")Teacher teacher); //查询总记录数
    public List<Teacher> limitTea(@Param("teacher")Teacher teacher,@Param("ns") int nd, @Param("ps")int ps); //分页
}
