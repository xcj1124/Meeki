package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.CoureseMsg;
import xaau.xcj.Curriculum.resource.management.mapper.VideoMapper;
import xaau.xcj.Curriculum.resource.management.service.VideoService;

/**
 * @auther: Meeki
 * @data: 2019/4/18 15:38
 * @message:
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    //添加视频
    public int addVideo(CoureseMsg coureseMsg) {
       int rows= this.videoMapper.addVideo(coureseMsg);
       return rows;
    }

    //删除视频
    @Override
    public int deleteVideo(int id) {
        int rows=this.videoMapper.deleteVideo(id);
        return rows;
    }

    @Override
    public CoureseMsg findTpId(int id) {
        return this.videoMapper.findTpId(id);
    }

    @Override
    public int updateVid(CoureseMsg coureseMsg) {
        return this.videoMapper.updateVid(coureseMsg);
    }

}
