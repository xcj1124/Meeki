package xaau.xcj.Curriculum.resource.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xaau.xcj.Curriculum.resource.management.entity.User;
import xaau.xcj.Curriculum.resource.management.mapper.UserMapper;
import xaau.xcj.Curriculum.resource.management.service.UserService;

/**
 * @auther: Meeki
 * @data: 2019/3/12 16:17
 * @message:
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User findUserById(Integer id) {
        return this.userMapper.findUserById(id);
    }

    @Override
    public int addUser(User user) {
        return this.userMapper.addUser(user);
    }

    @Override
    public int updataUser(String id, User user) {
        return this.userMapper.updataUser(id, user);
    }

    @Override
    public int updateImage(String imgUrl, String id) {
        return this.userMapper.updateImage(imgUrl, id);
    }

    @Override
    public String findUserPwd(String id,String oldPwd) {
        String pwd= this.userMapper.findUserPwd(id);
        if(pwd.equals(oldPwd)){
            return "ok";
        }else{
            return "no";
        }
    }

    @Override
    public String updatePwd(String pwd,String id) {
         int row=this.userMapper.updatePwd(pwd, id);
         if(row>0){
             return "ok";
         }else{
             return "no";
         }
    }
}
