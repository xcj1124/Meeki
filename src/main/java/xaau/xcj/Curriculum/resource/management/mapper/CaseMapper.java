package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import xaau.xcj.Curriculum.resource.management.entity.Case;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/4/23 14:31
 * @message:案例映射层
 */
public interface CaseMapper {
    //案例分页查询
    public int caseSum(@Param("cases") Case cases); //查询总记录数
    public List<Case> findCase(@Param("cases") Case cases,@Param("ns") int ns, @Param("ps") int ps);  //分页查询
    @Insert("INSERT INTO `case`(topic,optionA,optionB,optionC,optionD,correctAnser) " +
            "VALUES(#{case.topic},#{case.optionA},#{case.optionB},#{case.optionC},#{case.optionD},#{case.correctAnser})")
    public int addCase(@Param("case") Case case1); //添加

    //删除案例
    @Delete("DELETE FROM `case` where id=#{id}")
    public int deleteCase(@Param("id") Integer id);
    //根据id查询
    public Case findCaseToId(@Param("id") Integer id);
    public int updateCase(@Param("ac") Case aCase);
}
