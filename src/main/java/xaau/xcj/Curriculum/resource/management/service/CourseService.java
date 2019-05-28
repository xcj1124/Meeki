package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.CoureseMsg;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/3/21 15:45
 * @message: 课程信息服务层接口
 */
public interface CourseService {
    public int findSum(CoureseMsg coureseMsg);

    public List<CoureseMsg> findCourse(CoureseMsg coureseMsg,int ns, int ps);
}
