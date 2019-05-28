package xaau.xcj.Curriculum.resource.management.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xaau.xcj.Curriculum.resource.management.entity.Plan;

import java.util.List;

public interface PlanMapper {
    public int sumPlan(@Param("plan")Plan plan);
    //分页查询
    public List<Plan> findPlan(@Param("plan")Plan plan,@Param("ns") int ns, @Param("ps") int ps );
    //删除
    @Delete("Delete from plan where id=#{id}")
    public int deletePlan(@Param("id") int id);
    //添加
    @Insert("INSERT INTO plan(name,teaName,time,msg) VALUES(#{plan.name},#{plan.teaName},#{plan.time},#{plan.msg})")
    public int addPlan(@Param("plan") Plan plan);

    @Select("select * from plan where id=#{id}")
    public Plan findP(@Param("id") int id);

    public int updatePlan(@Param("p") Plan plan);
}
