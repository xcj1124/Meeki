package xaau.xcj.Curriculum.resource.management.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaau.xcj.Curriculum.resource.management.entity.Board;
import xaau.xcj.Curriculum.resource.management.mapper.BoardMapper;
import xaau.xcj.Curriculum.resource.management.service.BoardService;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/8 18:05
 * @message:
 */
@Service
public class BoardServiceImpl implements BoardService {
    @Autowired
    private BoardMapper boardMapper;
    @Override
    public int addConsume(Board board) {
        return this.boardMapper.addConsume(board);
    }

    @Override
    public int allConsumeNum() {
        return this.boardMapper.allConsumeNum();
    }

    @Override
    public List<Board> findConsumeToNum(int ns, int ps) {
        return this.boardMapper.findConsumeToNum(ns, ps);
    }

    @Override
    public String getUserName(int id) {
        return this.boardMapper.getUserName(id);
    }
}
