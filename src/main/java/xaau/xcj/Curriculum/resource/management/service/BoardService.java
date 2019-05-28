package xaau.xcj.Curriculum.resource.management.service;

import xaau.xcj.Curriculum.resource.management.entity.Board;

import java.util.List;

/**
 * @auther: Meeki
 * @data: 2019/5/8 18:02
 * @message:
 */
public interface BoardService {
    public  int addConsume(Board board);

    // 查询总的留言数
    public int allConsumeNum();

    // 分列查询留言
    public List<Board> findConsumeToNum(int ns, int ps);

    public String getUserName(int id);

}
