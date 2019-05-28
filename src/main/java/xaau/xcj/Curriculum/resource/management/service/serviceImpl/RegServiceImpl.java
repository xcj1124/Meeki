package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.mapper.RegisterMapper;
import xaau.xcj.Curriculum.resource.management.service.RegService;

/**
 * @auther: Meeki
 * @data: 2019/3/20 14:26
 * @message:
 */
@Service
public class RegServiceImpl implements RegService {
    @Autowired
    private RegisterMapper registerMapper;

    @Override
    public User checkUser(String id) {
        return this.registerMapper.checkUser(id);
    }

    @Override
    public int regUser(User user) {
        return this.registerMapper.regUser(user);
    }
}
