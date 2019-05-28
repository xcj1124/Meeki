package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.Exercise;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/15 10:09
 * @message:
 */
public interface ExerciseService  {
   public List<Exercise> limitTest(int num);
   //查询总记录数
   public int findSum(Exercise exercise);

   //分页查询
   public List<Exercise> findEx(Exercise  exercise,int ns,int ps);

   //添加试题
   public String addTest(Exercise exercise);

   //删除试题

   public String deleteTest(int id);

   //修改试题

   //根据id查出信息
   public Exercise findTest(int id);
   //修改
   public String updataTest(Exercise exercise);
}

