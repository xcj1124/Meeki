package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.CoureseMsg;

/**
 * @auther: Meeki
 * @data: 2019/4/18 15:37
 * @message:
 */
public interface VideoService {
    //添加视频
    public int addVideo(CoureseMsg coureseMsg);
    //删除视频
    public int deleteVideo(int id);
    //根据id查询视频信息
    public CoureseMsg findTpId(int id);
    //修改视频
    public int updateVid(CoureseMsg coureseMsg);
}
