package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.Plan;

import java.util.List;

public interface PlanService {
    public int sumPlan(Plan plan);  //总数
    public List<Plan> findPlan(Plan plan,int ns,int ps ); //分页
    public int deletePlan(int id);
    public int addPlan(Plan plan);
    public Plan findP(int id);

    public int updatePlan(Plan plan);
}
