package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.Teacher;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/6 20:41
 * @message:
 */
public interface TeacherTeaService {
    public int totalTea(Teacher teacher); //查询总记录数
    public List<Teacher> limitTea(Teacher teacher,int ns, int ps); //分页
}
