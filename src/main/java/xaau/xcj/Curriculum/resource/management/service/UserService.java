package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.User;

public interface UserService {
    public User findUserById(Integer id);
    public int addUser(User user);
    public int updataUser(String id,User user);
    public int updateImage(String imgUrl, String id);
    public String findUserPwd(String id,String oldPwd); //根据id查看密码旧密码是否正确
    public String updatePwd(String pwd,String id); //修改密码
}
