package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.Teacher;
import xaau.xcj.Curriculum.resource.management.mapper.TeacherMapper;
import xaau.xcj.Curriculum.resource.management.service.TeacherTeaService;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/8 16:28
 * @message:
 */
@Service
public class TeacherTeaServiceImpl implements TeacherTeaService {
    @Autowired
    private TeacherMapper teacherMapper;
    @Override
    public int totalTea(Teacher teacher) {
        return this.teacherMapper.totalTea(teacher);
    }

    @Override
    public List<Teacher> limitTea(Teacher teacher,int ns, int ps) {
        return this.teacherMapper.limitTea(teacher,ns, ps);
    }
}
