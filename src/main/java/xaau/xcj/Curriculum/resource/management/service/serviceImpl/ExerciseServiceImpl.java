package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.Exercise;
import xaau.xcj.Curriculum.resource.management.mapper.ExerciseMapper;
import xaau.xcj.Curriculum.resource.management.service.ExerciseService;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/15 10:23
 * @message:
 */
@Service
public class ExerciseServiceImpl implements ExerciseService {
    @Autowired
    private ExerciseMapper exerciseMapper;

    @Override
    public List<Exercise> limitTest(int num) {
        return this.exerciseMapper.limitTest(num);
    }

    @Override
    public int findSum(Exercise exercise) {
        return this.exerciseMapper.findSum(exercise);
    }

    @Override
    public List<Exercise> findEx(Exercise exercise, int ns, int ps) {
        return this.exerciseMapper.findEx(exercise, ns, ps);
    }

    @Override
    public String addTest(Exercise exercise) {
        int row=this.exerciseMapper.addTest(exercise);
       if(row>0){
           return "ok";
       }else{
            return "no";
        }
    }

    @Override
    public String deleteTest(int id) {
        int row=this.exerciseMapper.deleteTest(id);
        if(row>0){
            return "ok";
        }else{
            return "no";
        }
    }

    @Override
    public Exercise findTest(int id) {
        return this.exerciseMapper.findTest(id);
    }

    @Override
    public String updataTest(Exercise exercise) {
        int row=this.exerciseMapper.updataTest(exercise);
        if(row>0){
            return "ok";
        }else{
            return "no";
        }
    }

}
