package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.Plan;
import xaau.xcj.Curriculum.resource.management.mapper.PlanMapper;
import xaau.xcj.Curriculum.resource.management.service.PlanService;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/13 16:20
 * @message:
 */
@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanMapper planMapper;
    @Override
    public int sumPlan(Plan plan) {
        return this.planMapper.sumPlan(plan);
    }

    @Override
    public List<Plan> findPlan(Plan plan,int ns, int ps) {
        return this.planMapper.findPlan(plan,ns, ps);
    }

    @Override
    public int deletePlan(int id) {
        return this.planMapper.deletePlan(id);
    }

    @Override
    public int addPlan(Plan plan) {
        return this.planMapper.addPlan(plan);
    }

    @Override
    public Plan findP(int id) {
        return this.planMapper.findP(id);
    }

    @Override
    public int updatePlan(Plan plan) {
        return this.planMapper.updatePlan(plan);
    }
}
