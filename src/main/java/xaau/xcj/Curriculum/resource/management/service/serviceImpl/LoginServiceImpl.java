package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.mapper.LoginMapper;
import xaau.xcj.Curriculum.resource.management.service.LoginService;

/**
 * @auther: Meeki
 * @data: 2019/3/19 9:12
 * @message:
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;
    @Override
    public User login(User user) {
       return this.loginMapper.login(user);
    }
}
