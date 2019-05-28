package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xaau.xcj.Curriculum.resource.management.entity.Exercise;

import java.util.List;

public interface ExerciseMapper {
    @Select("SELECT * from exercise ORDER BY RAND() LIMIT #{num}")
    public List<Exercise> limitTest(@Param("num") int num);


    //查询总记录数
    public int findSum(@Param("ex")Exercise exercise);

    //分页查询
    public List<Exercise> findEx(@Param("ex")Exercise  exercise,@Param("ns") int ns, @Param("ps") int ps);

    //添加试题
    @Insert("INSERT INTO `exercise`(topic,optionA,optionB,optionC,optionD,result) " +
            "VALUES(#{ex.topic},#{ex.optionA},#{ex.optionB},#{ex.optionC},#{ex.optionD},#{ex.result})")
    public int addTest(@Param("ex") Exercise exercise);

    //删除试题
    @Delete("DELETE from exercise where id=#{id}")
    public int deleteTest(@Param("id") int id);

    //修改试题

    //根据id查出信息
    @Select("SELECT * from exercise where id=#{id}")
    public Exercise findTest(@Param("id") int id);
    //修改
    public int updataTest(@Param("ex") Exercise exercise);
}
