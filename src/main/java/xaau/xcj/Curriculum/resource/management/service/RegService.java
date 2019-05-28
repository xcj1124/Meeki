package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.User;

/**
 * @auther: Meeki
 * @data: 2019/3/20 14:14
 * @message:注册服务层
 */
public interface RegService {
    public User checkUser(String id);
    public int regUser(User user);
}
