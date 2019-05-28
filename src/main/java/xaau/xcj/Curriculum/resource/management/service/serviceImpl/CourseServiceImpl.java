package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.CoureseMsg;
import xaau.xcj.Curriculum.resource.management.mapper.CourseMapper;
import xaau.xcj.Curriculum.resource.management.service.CourseService;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/3/21 15:48
 * @message: 服务层
 */
@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public int findSum(CoureseMsg coureseMsg) {
        return this.courseMapper.findSum(coureseMsg);
    }

    @Override
    public List<CoureseMsg> findCourse(CoureseMsg coureseMsg,int ns, int ps) {
        return this.courseMapper.findCourse(coureseMsg,ns, ps);
    }
}
